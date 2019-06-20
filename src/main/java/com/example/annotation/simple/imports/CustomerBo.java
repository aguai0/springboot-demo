package com.example.annotation.simple.imports;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerBo {

    public void printMsg(String msg){
        System.out.println("CustomerBo : " + msg);
    }

    @Bean(name = "testCustomerBo")
    public CustomerBo testCustomerBo(){
        return new CustomerBo();
    }
}