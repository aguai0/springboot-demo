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

    @RequestMapping(value = "/annotation")
    @OneSimpleAnnotation(key = "test=1")
    public String test(String req){
        System.out.println("annotation test ..."+req);
        return "success";
    }

    public static void main(String[] args) {
        //AnnotationUtils.findAnnotation()
        StandardEvaluationContext context = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setTeacherName("test");
        teacher.setTeacherPwd("123");
        context.setVariable("s0",teacher);

        //Expression annotationAttribute = parser.parseExpression("#s0");
        //Teacher value = annotationAttribute.getValue(context, Teacher.class);
        Expression annotationAttribute = parser.parseExpression("#s0.id+','+#s0.teacherName");
        String value = annotationAttribute.getValue(context, String.class);
        System.out.println(value.toString());

    }
}