package com.example.demo.dao.security;

import com.example.demo.domain.security.PermissionVO;

import java.util.List;


public interface PermissionDao {

    List<PermissionVO> getAll();
}
