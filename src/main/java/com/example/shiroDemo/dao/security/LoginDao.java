package com.example.shiroDemo.dao.security;

import com.example.shiroDemo.domain.security.vo.UserVO;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {
    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    UserVO getUser(@Param("userName") String userName, @Param("password") String password);
}
