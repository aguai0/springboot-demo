package com.example.annotation.simple.value;


import com.example.annotation.simple.configuration.MyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigurationApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ReadValueFromPropertySource.class);
        MyBean myBean = (MyBean) context.getBean("myTestBean");

        System.out.println("myBean:"+myBean);
    }
}