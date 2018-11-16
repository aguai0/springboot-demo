package com.example.demo.dao.security;

import com.example.demo.domain.security.RoleVO;

import java.util.List;

public interface RoleDAO{

    Integer count(RoleVO roleVO);

    List<RoleVO> findList(RoleVO roleVO);

    List<RoleVO> getAll();

    void delete(Long roleId);

    void insert(RoleVO roleVO);

    void update(RoleVO roleVO);
}