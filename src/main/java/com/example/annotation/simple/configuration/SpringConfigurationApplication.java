package com.example.annotation.simple.configuration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringConfigurationApplication {

    public static ApplicationContext context;
    public  void initApplicationContext(ApplicationContext context){
         context = context;
    }

    public static void main(String[] args) {
     /*
     //1.基于注解方式
     // 因为我们加载的@Configuration 是基于注解形式的，所以需要创建AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册MyConfiguration 类并刷新bean 容器。
        context.register(MyConfiguration.class);
        context.refresh();*/
     //2.基于配置文件方式
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

    }
}