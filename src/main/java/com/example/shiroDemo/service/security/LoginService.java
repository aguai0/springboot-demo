package com.example.shiroDemo.service.security;

import com.example.shiroDemo.domain.security.po.UserPermissionPO;
import com.example.shiroDemo.domain.security.vo.UserVO;

public interface LoginService {

    /**
     * 登录表单提交
     *
     * @param userVO
     * @return
     */
    UserVO authLogin(UserVO userVO);

    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    UserVO getUser(String userName, String password);

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    UserPermissionPO getInfo();

    /**
     * 退出登录
     *
     * @return
     */
    Boolean logout();
}
