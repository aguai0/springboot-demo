package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 * All Rights Reserved.
 *
 */
@Component
public class RedisLock {
    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLock.class);


    @Autowired
    RedisPoolFactory redisPoolFactory;

    public boolean lock(KeyPrefix prefix, String key, String value, Long lockExpireTimeOut,
                         Long lockWaitTimeOut) {
        /*Jedis jedis;
        String realKey = prefix.getPrefix() + key;
        try {
            JedisPool jedisPool = redisPoolFactory.jedisPoolFactory();
            jedis = jedisPool.getResource();
            Long deadTimeLine = System.currentTimeMillis() + lockWaitTimeOut;

            for (;;) {
                String result = jedis.set(realKey, value, "NX", "EX", lockExpireTimeOut);
                System.out.println("realKey："+realKey+" value:"+value+" result:"+result);
                if ("OK".equals(result)) {
                    return true;
                }

                lockWaitTimeOut = deadTimeLine - System.currentTimeMillis();

                if (lockWaitTimeOut <= 0L) {
                    return false;
                }
            }
        } catch (Exception ex) {
            LOGGER.error("lock error",ex);
        } finally {
            //  returnToPool(jedis);
        }*/

        return false;
    }

    public boolean unlock(KeyPrefix prefix, String key, String value) {

        /*Jedis jedis = null;
        try {
            JedisPool jedisPool = redisPoolFactory.jedisPoolFactory();
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;

            String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

            Object result = jedis.eval(luaScript, Collections.singletonList(realKey),
            Collections.singletonList(value));

            if ("1".equals(result)) {
                return true;
            }

        } catch (Exception ex) {
            LOGGER.error("unlock error",ex);
        } finally {
          //  returnToPool(jedis);
        }*/
        return false;

    }


}