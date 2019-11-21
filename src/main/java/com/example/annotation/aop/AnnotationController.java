package com.example.annotation.aop;


import com.example.mybatisPlus.vo.Teacher;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationController {
    private static StandardEvaluationContext context = new StandardEvaluationContext();
    private static ExpressionParser parser = new SpelExpressionParser();

    @RequestMapping(value = "/annotation")
    @OneSimpleAnnotation(key = "#test")
    public String testPage(String test){
        return test;
    }

    public static void main(String[] args) {
        //AnnotationUtils.findAnnotation()

        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setTeacherName("test");
        teacher.setTeacherPwd("123");
        context.setVariable("s0",teacher);

        Expression annotationAttribute = parser.parseExpression("#s0");
        Teacher value = annotationAttribute.getValue(context, Teacher.class);
        //Expression annotationAttribute = parser.parseExpression("#s0.id+','+#s0.teacherName+','+#s0.teacherPwd");
        //String value = annotationAttribute.getValue(context, String.class);
        System.out.println(value.toString());

    }
}