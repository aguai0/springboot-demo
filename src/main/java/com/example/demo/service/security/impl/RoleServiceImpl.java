package com.example.demo.service.security.impl;

import com.example.demo.dao.security.RoleDAO;
import com.example.demo.domain.security.RoleVO;
import com.example.demo.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDAO roleDAO;

    @Override
    public Integer count(RoleVO roleVO) {
        return roleDAO.count(roleVO);
    }

    @Override
    public List<RoleVO> findList(RoleVO roleVO) {
        return roleDAO.findList(roleVO);
    }

    @Override
    public List<RoleVO> getAllRoles() {
        return roleDAO.getAll();
    }

    @Override
    public void delByRoleId(Long roleId) {
        roleDAO.delete(roleId);
    }

    @Override
    public void save(RoleVO roleVO) {
        roleDAO.insert(roleVO);
    }

    @Override
    public void update(RoleVO roleVO) {
        roleDAO.update(roleVO);
    }

}