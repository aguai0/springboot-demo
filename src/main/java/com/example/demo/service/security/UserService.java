package com.example.demo.service.security;

import com.example.demo.domain.security.UserVO;

import java.util.List;

public interface UserService {

    Integer count(UserVO userVO);

    List<UserVO> findList(UserVO userVO);

    void update(UserVO userVO);

    void save(UserVO userVO);

    UserVO queryById(Long id);

    void deleteById(Long id);

    UserVO findByName(String userName);
}