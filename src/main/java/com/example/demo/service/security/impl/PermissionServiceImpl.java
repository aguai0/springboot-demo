package com.example.demo.service.security.impl;

import com.example.demo.dao.security.PermissionDao;
import com.example.demo.domain.security.PermissionVO;
import com.example.demo.service.security.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionServiceImpl implements PermissionService {

    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<PermissionVO> listAllPermission() {
        return permissionDao.getAll();
    }
}
