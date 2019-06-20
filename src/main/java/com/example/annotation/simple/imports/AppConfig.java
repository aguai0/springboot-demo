package com.example.annotation.simple.imports;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {CustomerBo.class,SchedulerBo.class})
public class AppConfig {
}