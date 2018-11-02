package com.example.demo.service.security;

import com.example.demo.domain.security.UserVO;

import java.util.List;
import java.util.Set;

public interface UserService {
    UserVO findByEmail(String email);

    Integer count(UserVO user);

    List<UserVO> list(UserVO user);

    void upsert(UserVO user);

    void delByEmail(String email);

    Set<String> findPermissions(String s);
}