package com.example.annotation.simple.imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerBo {

    public void printMsg(String msg){
        System.out.println("SchedulerBo : " + msg);
    }

    @Bean
    public SchedulerBo testSchedulerBo(){
        return new SchedulerBo();
    }
}