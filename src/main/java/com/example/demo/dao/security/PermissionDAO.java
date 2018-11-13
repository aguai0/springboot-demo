package com.example.demo.dao.security;

import com.example.demo.domain.security.PermissionVO;
import com.example.demo.domain.security.UserPermissionPO;

import java.util.List;
import java.util.Set;

/**
 * @author: hxy
 * @date: 2017/10/30 13:28
 */
public interface PermissionDao {
    /**
     * 查询用户的角色 菜单 权限
     *
     * @param username
     * @return
     */
    UserPermissionPO getUserPermission(String username);

    /**
     * 查询所有的菜单
     *
     * @return
     */
    Set<String> getAllMenu();

    /**
     * 查询所有的权限
     *
     * @return
     */
    Set<String> getAllPermission();

    PermissionVO queryById(long id);

    void save(PermissionVO permission);

    void update(PermissionVO permission);

    void delete(long id);

    List<PermissionVO> getList(PermissionVO permission);
}
