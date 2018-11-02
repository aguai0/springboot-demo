package com.example.demo.service.security;

import com.example.demo.domain.security.PermissionVO;

import java.util.List;

public interface PermissionService {
    List<PermissionVO> list(PermissionVO permission);

    PermissionVO findById(long l);

    void add(PermissionVO permission);

    void updateById(PermissionVO permission);

    void delById(long l);
}