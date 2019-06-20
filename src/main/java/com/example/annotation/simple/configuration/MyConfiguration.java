package com.example.annotation.simple.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig 加入@Configuration 注解，表明这就是一个配置类。有一个myBean()的方法，返回一个MyBean()的实例，并用@Bean 进行注释，
 * 表明这个方法是需要被Spring进行管理的bean。@Bean 如果不指定名称的话，默认使用myBean名称，也就是小写的名称
 */
@Configuration
public class MyConfiguration {

    /**
     * 默认名称为myBean 的bean随着容器的加载而加载
     */
    @Bean
    public MyBean myBean(){
        System.out.println("myBean Initialized");
        return new MyBean();
    }
}