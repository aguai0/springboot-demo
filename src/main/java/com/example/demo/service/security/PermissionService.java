package com.example.demo.service.security;

import com.example.demo.domain.security.PermissionVO;

import java.util.List;


public interface PermissionService {

    /**
     * 查询所有权限, 给角色分配权限时调用
     *
     * @return
     */
    List<PermissionVO> listAllPermission();

}
