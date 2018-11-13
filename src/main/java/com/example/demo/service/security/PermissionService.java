package com.example.demo.service.security;

import com.example.demo.domain.security.PermissionVO;
import com.example.demo.domain.security.UserPermissionPO;

import java.util.List;


public interface PermissionService {
    /**
     * 查询某用户的 角色  菜单列表   权限列表
     *
     * @param username
     * @return
     */
    UserPermissionPO getUserPermission(String username);

    List<PermissionVO> list(PermissionVO permission);

    PermissionVO findById(long id);

    void add(PermissionVO permission);

    void updateById(PermissionVO permission);

    void delById(long id);
}
