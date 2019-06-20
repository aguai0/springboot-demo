package com.example.annotation.simple.componentScan;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigurationApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfigurationScan.class);
        context.refresh();

        // 获取启动过程中的bean 定义的名称
        String[] names = context.getBeanDefinitionNames();
        for(String bean: names) {
            System.out.println("bean: "+bean);
        }
        context.close();

        /**
         * 由输出可以清楚的看到，上述定义的五个类成功被@ComponentScan 扫描到，并在程序启动的时候进行加载。
         bean: org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         bean: org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         bean: org.springframework.context.annotation.internalRequiredAnnotationProcessor
         bean: org.springframework.context.annotation.internalCommonAnnotationProcessor
         bean: org.springframework.context.event.internalEventListenerProcessor
         bean: org.springframework.context.event.internalEventListenerFactory
         bean: myConfiguration
         bean: userBean
         bean: userConfiguration
         bean: userController
         bean: userDao
         bean: userService
         */
    }
}