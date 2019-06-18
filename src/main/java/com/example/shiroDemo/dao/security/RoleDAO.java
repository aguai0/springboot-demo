package com.example.shiroDemo.dao.security;

import com.alibaba.fastjson.JSONObject;
import com.example.shiroDemo.domain.security.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDAO{

    Integer count();

    List<JSONObject> findRolePermissions(RoleVO role);

    List<RoleVO> getAll();

    void delete(Long roleId);

    Long insert(RoleVO roleVO);

    void update(RoleVO roleVO);

    JSONObject getRoleInfo(@Param("roleId") Long roleId);
}