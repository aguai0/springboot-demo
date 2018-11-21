package com.example.demo.dao.security;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.security.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PermissionDao {

    List<JSONObject> getAllPermission();

    void insert(RoleVO roleVO);

    int removeOldPermission(@Param("roleId") Long roleId, @Param("permissions") List<Integer> permissions);
}
