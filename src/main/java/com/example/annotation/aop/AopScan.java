package com.example.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AopScan {
    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(AopScan.class);

    @Pointcut("@annotation(com.example.annotation.aop.OneSimpleAnnotation)")
    private void annotationPointCut(){}

    @Before("annotationPointCut()")
    public void doBefore(JoinPoint joinPoint){
        LOGGER.info("测试开始..........");
        //joinPoint.getArgs();//輸入的參數列表
        //joinPoint.getTarget().getClass().getName();//類全路徑
        //joinPoint.getSignature().getDeclaringTypeName();//接口全路徑
        //joinPoint.getSignature().getName();//調用的方法

        try {
            String className = joinPoint.getTarget().getClass().getName();
            //String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();//方法参数
            String param = (String)arguments[0];//参数值
            LOGGER.info("param:{}",param);
            Class targetClass = Class.forName(className);
            Method[] methods = targetClass.getMethods();
            ExpressionParser parser = new SpelExpressionParser();

            for(int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                OneSimpleAnnotation simpleAnnotation = method.getAnnotation(OneSimpleAnnotation.class);
                //OneSimpleAnnotation simpleAnnotation1 = AnnotationUtils.findAnnotation(method, OneSimpleAnnotation.class);
                if(simpleAnnotation!=null){
                    String value = simpleAnnotation.key();
                    //获取方法的参数集合
                    //Parameter[] parameters = method.getParameters();
                    StandardEvaluationContext context = new StandardEvaluationContext();
                    context.setVariable("key", value);

                    Expression expression = parser.parseExpression("#key");
                    String parameter = expression.getValue(context,String.class);
                    LOGGER.info("parameter:{}",parameter);
                }
            }
            //joinPoint.proceed();
        } catch (Exception e) {
            LOGGER.error("解析annotation错误",e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}