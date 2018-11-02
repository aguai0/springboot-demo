package com.example.demo.dao.security;


import com.example.demo.domain.security.PermissionVO;

import java.util.List;

public interface PermissionDAO {

    List<PermissionVO> findList(PermissionVO record);

    void insert(PermissionVO record);

    int updateById(PermissionVO record);

    PermissionVO findById(Long id) ;

}