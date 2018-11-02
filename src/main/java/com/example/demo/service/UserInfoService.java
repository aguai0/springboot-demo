package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserInfoService {

    /**通过username查找用户信息;*/
    public User findByUsername(String username);
}