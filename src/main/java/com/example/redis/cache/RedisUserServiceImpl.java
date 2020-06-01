package com.example.redis.cache;

import com.example.redis.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0 2020/4/14 15:19 by aguai
 */
@Service
public class RedisUserServiceImpl implements RedisUserService {

    public static Logger logger = LogManager.getLogger(RedisUserServiceImpl.class);

    private static Map<Integer, User> userMap = new HashMap<>();
    static {
        userMap.put(1, new User(1, "肖战", 25));
        userMap.put(2, new User(2, "王一博", 26));
        userMap.put(3, new User(3, "杨紫", 24));
    }

    /**
     *
     ①@Cacheable
     根据方法的请求参数对其结果进行缓存：
     Key：缓存的 Key，可以为空，如果指定要按照 SPEL 表达式编写，如果不指定，则按照方法的所有参数进行组合。
     Value：缓存的名称，必须指定至少一个（如 @Cacheable (value='user')或者 @Cacheable(value={'user1','user2'})）
     Condition：缓存的条件，可以为空，使用 SPEL 编写，返回 true 或者 false，只有为 true 才进行缓存。
     ②@CachePut
     根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用。参数描述见上。
     ③@CacheEvict
     根据条件对缓存进行清空：
     Key：同上。
     Value：同上。
     Condition：同上。
     allEntries：是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存。
     beforeInvocation：是否在方法执行前就清空，缺省为 false，如果指定为 true，则在方法还没有执行的时候就清空缓存。缺省情况下，如果方法执行抛出异常，则不会清空缓存。
     */

    @CachePut(value ="user", key = "#user.id")
    @Override
    public User save(User user) {
        userMap.put(user.getId(), user);
        logger.info("进入save方法，当前存储对象：{}", user.toString());
        return user;
    }

    @CacheEvict(value="user", key = "#id")
    @Override
    public void delete(int id) {
        userMap.remove(id);
        logger.info("进入delete方法，删除成功");
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Integer id) {
        logger.info("进入get方法，当前获取对象：{}", userMap.get(id)==null?null:userMap.get(id).toString());
        return userMap.get(id);
    }

}