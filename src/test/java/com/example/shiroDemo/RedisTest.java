package com.example.shiroDemo;

import com.example.redis.RedisLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * All Rights Reserved.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisLock redisLock;

    @Test
    public void testLock(){
       /* KeyPrefix keyPrefix = new BasePrefix(1000,"test");
        boolean lock = redisLock.lock(keyPrefix,"lock","1",30L,5L);
        System.out.println(lock);*/
    }
}