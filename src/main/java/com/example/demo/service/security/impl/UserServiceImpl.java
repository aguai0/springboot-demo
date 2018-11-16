package com.example.demo.service.security.impl;

import com.example.demo.dao.security.UserDAO;
import com.example.demo.domain.security.UserVO;
import com.example.demo.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    public Integer count(UserVO collect) {
        int count = userDAO.count(collect);
        return count;
    }

    @Override
    public List<UserVO> findList(UserVO userVO) {
        List<UserVO> list = userDAO.findList(userVO);
        return list;
    }

    @Override
    public void update(UserVO userVO) {
        userDAO.update(userVO);
    }

    @Override
    public void save(UserVO userVO) {
        userDAO.insert(userVO);
    }


}