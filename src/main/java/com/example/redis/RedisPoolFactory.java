package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 * All Rights Reserved.
 *
 */
@Component
public class RedisPoolFactory {

    @Autowired
    private RedisConfig redisConfig;

    /*public JedisPool jedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxActive());
        poolConfig.setTestOnBorrow(true);
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait());
        JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout(), redisConfig.getPassword(), 0);
        return jp;
    }*/
}