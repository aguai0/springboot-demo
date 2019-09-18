package com.example.annotation.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class AopScan {
    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(AopScan.class);

    private static LocalVariableTableParameterNameDiscoverer parameterNameDiscover = new LocalVariableTableParameterNameDiscoverer();

    private static ExpressionParser parser = new SpelExpressionParser();

    private static Map<String,String> methodAndParamCache = new ConcurrentHashMap<>();

    private static Map<String,String[]> parameterNamesCache = new ConcurrentHashMap<>();

    /** 测试用的本地缓存，可以替换成redis缓存 */
    private static Map<String,String> localCache = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.example.annotation.aop.OneSimpleAnnotation)")
    private void annotationPointCut(){}


    /**
     StandardEvaluationContext context = new StandardEvaluationContext();
     context.setVariable("key", key);
     Expression expression = parser.parseExpression("#key");
     String parameter = expression.getValue(context, String.class);
     LOGGER.info("parameter:{}", parameter);
     */
    @Around("annotationPointCut()")
    public Object annotationResult(ProceedingJoinPoint joinPoint) {
        LOGGER.info("测试开始..........");
        try {
            Method method = this.getMethod(joinPoint);
            OneSimpleAnnotation simpleAnnotation = method.getAnnotation(OneSimpleAnnotation.class);
            /** OneSimpleAnnotation simpleAnnotation1 = AnnotationUtils.findAnnotation(method, OneSimpleAnnotation.class); */

            String key = simpleAnnotation.key();

            String paramValue = (String) getAnnotationKeyOfValue(key, joinPoint);
            Object result = localCache.get(paramValue);
            if(result != null) {
                return result;
            }

            result = joinPoint.proceed();
            LOGGER.info("result:{}", result);
            if(result != null) {
                localCache.put(paramValue, String.valueOf(result));
            }

            return result;
        } catch (Throwable throwable) {
            LOGGER.error("解析annotation错误",  throwable.getMessage());
        }
        return null;
    }

    /**
     * 获得注解中key的value值
     */
    private Object getAnnotationKeyOfValue(String key,JoinPoint joinPoint) {

        //获取方法所有参数名称
        String methodLongName = joinPoint.getSignature().toLongString();
        String[] parameterNames = parameterNamesCache.get(methodLongName);
        if(parameterNames == null) {
            Method method = getMethod(joinPoint);
            parameterNames = parameterNameDiscover.getParameterNames(method);
            //缓存参数名称
            parameterNamesCache.put(methodLongName, parameterNames);
        }
        // add args to expression context
        StandardEvaluationContext context = new StandardEvaluationContext();
        Object[] args = joinPoint.getArgs();
        if(args.length == parameterNames.length) {
            for(int i = 0, len = args.length; i < len; i++) {
                context.setVariable(parameterNames[i], args[i]);
            }
        }

        Expression expression = parser.parseExpression(key);
        Object value = expression.getValue(context, Object.class);
        return value;
    }

    private Method getMethod(JoinPoint joinPoint){
        String methodLongName = joinPoint.getSignature().toLongString();
        String methodNameAndParam = methodAndParamCache.get(methodLongName);

        if(StringUtils.isEmpty(methodNameAndParam)) {
            methodNameAndParam = getMethodNameAndParams(methodLongName);
            methodAndParamCache.put(methodLongName, methodNameAndParam);
        }

        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method method = null;
        for(int i = 0, len = methods.length; i < len; i++) {
            String targetMethodLongName = methods[i].toString();
            String targetMethodAndParam = methodAndParamCache.get(targetMethodLongName);
            if(StringUtils.isEmpty(targetMethodAndParam)) {
                targetMethodAndParam = getMethodNameAndParams(targetMethodLongName);
                methodAndParamCache.put(targetMethodLongName, targetMethodAndParam);
            }
            if(targetMethodAndParam.equals(methodNameAndParam)) {
                method = methods[i];
                break;
            }
        }
        return method;
    }


    private String getMethodNameAndParams(String longName){
        int leftBracketIndex = longName.indexOf("(");
        int rightBracketIndex = longName.indexOf(")");
        int lastDotBeforeMethod = 0;
        for(int i=leftBracketIndex;i>=0;i--){
            if(longName.charAt(i)=='.'){
                lastDotBeforeMethod=i;
                break;
            }
        }
        return longName.substring(++lastDotBeforeMethod,++rightBracketIndex);
    }
}