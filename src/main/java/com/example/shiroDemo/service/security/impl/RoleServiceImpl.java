package com.example.shiroDemo.service.security.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.shiroDemo.common.enums.StatusEnum;
import com.example.shiroDemo.dao.security.PermissionDao;
import com.example.shiroDemo.dao.security.RoleDAO;
import com.example.shiroDemo.domain.security.po.UserPermissionPO;
import com.example.shiroDemo.domain.security.vo.RoleVO;
import com.example.shiroDemo.service.security.RoleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    PermissionDao permissionDao;
    @Override
    public Integer count() {
        return roleDAO.count();
    }

    @Override
    public List<UserPermissionPO> findList() {
        List<JSONObject> jsonObjects = roleDAO.findRolePermissions(null);
        List<UserPermissionPO> roles = new ArrayList<>();
        for(JSONObject jb :jsonObjects){
            UserPermissionPO userPermissionPO = JSONObject.toJavaObject(jb, UserPermissionPO.class);
            roles.add(userPermissionPO);
        }

        return roles;
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
    @Transactional
    public void save(RoleVO roleVO) {
        roleVO.setStatus(StatusEnum.valid.getCode());
        roleVO.setCreateName((String) SecurityUtils.getSubject().getPrincipal());
        roleDAO.insert(roleVO);

        List<String> permissionIds = Arrays.asList(roleVO.getPermissions().split(","));
        roleVO.setPermissionIds(permissionIds);
        permissionDao.insert(roleVO);
    }

    @Override
    @Transactional
    public void update(RoleVO roleVO) {
        roleVO.setModifyName((String) SecurityUtils.getSubject().getPrincipal());
        roleDAO.update(roleVO);

        //删除原来角色菜单
        JSONObject roleInfo = roleDAO.getRoleInfo(roleVO.getId());
        Set<Integer> oldPerms = (Set<Integer>) roleInfo.get("permissionIds");

        List<Integer>  oldPermissions = new ArrayList<>();
        for(Integer permissionId: oldPerms) {
            oldPermissions.add(permissionId);
        }
        if(!oldPermissions.isEmpty()){
            permissionDao.removeOldPermission(roleVO.getId(),oldPermissions);
        }

        //插入更新后的角色菜单
        List<String> permissionIds = Arrays.asList(roleVO.getPermissions().split(","));
        roleVO.setPermissionIds(permissionIds);
        roleVO.setCreateName((String) SecurityUtils.getSubject().getPrincipal());
        roleVO.setStatus(StatusEnum.valid.getCode());
        permissionDao.insert(roleVO);
    }

    @Override
    public RoleVO queryById(Long id) {
        JSONObject roleInfo = roleDAO.getRoleInfo(id);

        RoleVO role = new RoleVO();
        if(roleInfo!=null){
            role.setRoleName(roleInfo.getString("roleName"));
            Set<Integer> permissionIds = (Set<Integer>) roleInfo.get("permissionIds");
            StringBuilder sbl = new StringBuilder();
            for(Integer permissionId :permissionIds) {
                sbl.append(permissionId).append(",");
            }
            role.setPermissions(sbl.toString());
            role.setId(id);
        }
        return role;
    }
}