package com.example.annotation.simple.value;

import com.example.annotation.simple.configuration.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ReadValueFromPropertySource {

    @Bean("myTestBean")
    public MyBean myBean(){
        return new MyBean();
    }
}