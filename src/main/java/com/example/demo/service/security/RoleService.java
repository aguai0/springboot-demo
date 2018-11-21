package com.example.demo.service.security;

import com.example.demo.domain.security.po.UserPermissionPO;
import com.example.demo.domain.security.vo.RoleVO;

import java.util.List;

public interface RoleService {

    void delByRoleId(Long roleId);

    void save(RoleVO roleVO);

    void update(RoleVO roleVO);

    Integer count();

    List<UserPermissionPO> findList();

    List<RoleVO> getAllRoles();

    RoleVO queryById(Long id);
}