package com.example.demo.service.security;

import com.example.demo.domain.security.RoleVO;

import java.util.List;

public interface RoleService {

    void delByRoleId(Long roleId);

    void save(RoleVO roleVO);

    void update(RoleVO roleVO);

    Integer count(RoleVO roleVO);

    List<RoleVO> findList(RoleVO roleVO);

    List<RoleVO> getAllRoles();
}