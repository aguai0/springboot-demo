package com.example.annotation.simple.imports;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * .@Import的定义(来自于JavaDoc)：表明一个或者多个配置类需要导入，
 * 提供与Spring XML中相等的功能，允许导入@Configuration 、@ImportSelector、@ImportBeanDefinitionRegistar的实现，
 * 以及常规组件类似于AnnotationConfigApplicationContext。可能用于类级别或者是原注解。
 * 如果XML或者其他非@Configuration标记的Bean资源需要被导入的话，使用@ImportResource。
 */
public class ImportWithConfiguration {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerBo customerBo = (CustomerBo) context.getBean("testCustomerBo");
        SchedulerBo schedulerBo = (SchedulerBo)context.getBean("testSchedulerBo");

        customerBo.printMsg("customerBoTest");
        schedulerBo.printMsg("schedulerBoTest");
    }
}