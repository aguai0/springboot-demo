package com.example.demo.dao.security;

import com.example.demo.domain.security.RoleVO;

public interface RoleDAO{


    int deleteByPrimaryKey(Long id);

    void insert(RoleVO record);

    void insertSelective(RoleVO record);

    RoleVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleVO record);

    int updateByPrimaryKey(RoleVO record);

    RoleVO findByCode(String roleCode);

}