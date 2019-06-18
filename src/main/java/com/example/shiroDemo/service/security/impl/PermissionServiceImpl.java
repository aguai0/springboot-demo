package com.example.shiroDemo.service.security.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.shiroDemo.dao.security.PermissionDao;
import com.example.shiroDemo.domain.security.po.PermissionPO;
import com.example.shiroDemo.service.security.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PermissionServiceImpl implements PermissionService {

    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<PermissionPO> getAllPermission() {
        List<JSONObject> jbs = permissionDao.getAllPermission();
        List<PermissionPO> permissionPOs = new ArrayList<>();
        for(JSONObject jb: jbs) {
            PermissionPO permissionPO = JSONObject.toJavaObject(jb, PermissionPO.class);
            permissionPOs.add(permissionPO);
        }
        return permissionPOs;
    }
}
