package com.example.redis.cache;

import com.example.redis.User;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0 2020/4/14 15:18 by aguai
 */
public interface RedisUserService {
    User save(User user);

    void delete(int id);

    User get(Integer id);
}