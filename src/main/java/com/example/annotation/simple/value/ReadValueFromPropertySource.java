package com.example.annotation.simple.value;

import com.example.annotation.simple.configuration.MyBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:beanName.properties")
@Configuration
public class ReadValueFromPropertySource {
    @Value("bean.name.repository")
    String beanName;

    @Bean("myTestBean")
    public MyBean myBean(){
        return new MyBean(beanName);
    }
}