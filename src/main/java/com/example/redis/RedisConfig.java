package com.example.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description:redis配置文件
 * All Rights Reserved.
 *
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    private String host;

    private int port;

    private String password;

    private int timeout;

    private int poolMaxActive;

    private int poolMaxIdle;

    private int poolMaxWait;

    private boolean testOnBorrow;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getPoolMaxActive() {
        return poolMaxActive;
    }

    public void setPoolMaxActive(int poolMaxActive) {
        this.poolMaxActive = poolMaxActive;
    }

    public int getPoolMaxIdle() {
        return poolMaxIdle;
    }

    public void setPoolMaxIdle(int poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public int getPoolMaxWait() {
        return poolMaxWait;
    }

    public void setPoolMaxWait(int poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
}