package com.example.annotation.simple.enviroment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * ​	@Configuration 通常和Environment 一起使用，
 *  通过@Environment 解析的属性驻留在一个或多个"属性源"对象中，@Configuration 类可以使用@PropertySource，
 *  像Environment 对象提供属性源
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EnvironmentConfig.class)
@Configuration
@PropertySource("classpath:beanName.properties")
public class EnvironmentConfig {

    /**
     *  @Autowired 是Spring提供的注解，通过AutowiredAnnotationBeanPostProessor 类实现注入。
     *  位于org.springframework.beans.factory.annotation 包内，是Spring 中的注解
     */
    @Autowired
    Environment environment;

    /**
     * .@Inject: 这是jsr330 的规范，通过AutowiredAnnotationBeanPostProcessor 类实现的依赖注入。
     * 位于javax.inject包内，是Java自带的注解。
     */
    @Inject
    //@Named("environment1")
    Environment environment1;

    /**
     * .@Resource 是jsr250规范的实现，@Resource通过CommonAnnotationBeanPostProcessor 类实现注入。
     * .@Resource 一般会指定一个name属性
     */
    @Resource
    Environment environment2;

    /**
     *  .@Autowired和@Inject基本是一样的，因为两者都是使用AutowiredAnnotationBeanPostProcessor来处理依赖注入。
     * 但是@Resource是个例外，它使用的是CommonAnnotationBeanPostProcessor来处理依赖注入。当然，两者都是BeanPostProcessor。
     */


    @Test
    public void testReadProperty(){
        // 获取bean.name.controller 的属性
        System.out.println("===="+environment.getProperty("bean.name.controller"));
        // 判断是否包含bean.name.component
        System.out.println("======"+environment.containsProperty("bean.name.component"));
        // 返回与给定键关联的属性值
        System.out.println("========"+environment.getRequiredProperty("bean.name.service"));
    }
}