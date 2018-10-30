package com.example.demo.repository;

import com.example.demo.domain.User;

import java.util.List;

public interface UserRepository {

    User login(User user);

    User register(User user);

    /**
     * 新增或者修改用户
     * @param user
     * @return
     */
    User saveOrUpateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据用户id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取所有用户的列表
     * @return
     */
    List<User> listUser();

    /**
     * 检查用户是否有效
     * @param user
     * @return
     */
    boolean checkUser(String user);
}