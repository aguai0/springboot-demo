package com.example.annotation.simple.componentScan;

import com.example.annotation.simple.configuration.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.annotation.simple.componentScan")
public class MyConfigurationScan {

    @Bean
    public MyBean myBean(){
        System.out.println("myBean Initialized");
        return new MyBean();
    }
}