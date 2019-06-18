package com.example.shiroDemo.service.security;

import com.example.shiroDemo.domain.security.po.PermissionPO;

import java.util.List;


public interface PermissionService {

    /**
     * 查询所有权限, 给角色分配权限时调用
     *
     * @return
     */
    List<PermissionPO> getAllPermission();

}
