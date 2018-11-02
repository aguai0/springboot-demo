package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserRepository userInfoDao;

    @Override
    public User findByUsername(String username) {

        ConcurrentMap<String, String> map = userInfoDao.checkUser(username);
        User userInfo = new User();
        if(map!=null){
            for(Map.Entry<String,String> entry : map.entrySet()){
                userInfo.setName(entry.getKey());
                userInfo.setPassword(entry.getValue());
            }
        }

        return userInfo;
    }
}