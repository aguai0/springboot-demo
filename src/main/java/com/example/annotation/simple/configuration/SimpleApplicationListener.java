package com.example.annotation.simple.configuration;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0 2019/12/27 18:03
 */
public class SimpleApplicationListener implements SpringApplicationRunListener{
    @Override
    public void starting() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {

    }

    @Override
    public void started(ConfigurableApplicationContext configurableApplicationContext) {

    }

    @Override
    public void running(ConfigurableApplicationContext configurableApplicationContext) {

    }

    @Override
    public void failed(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {

    }
}