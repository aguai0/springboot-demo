package com.example.demo.dao.security;

import com.example.demo.domain.security.vo.UserVO;

import java.util.List;

/**
 * Description: 用户DAO
 *
 */
public interface UserDAO {

    int count(UserVO record);

    List<UserVO> findList(UserVO record);

    void insert(UserVO record);

    void update(UserVO userVO);

    UserVO queryUser(UserVO userVO);

    void deleteById(Long id);
}
