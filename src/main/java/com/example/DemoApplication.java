package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages ={"com.example.shiroDemo.dao.security","com.example.mybatisPlus.mapper"})
//@EnableCaching
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class,args);
	}
}
