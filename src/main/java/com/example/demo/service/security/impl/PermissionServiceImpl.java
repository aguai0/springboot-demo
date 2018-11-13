package com.example.demo.service.security.impl;

import com.example.demo.dao.security.PermissionDao;
import com.example.demo.domain.security.PermissionVO;
import com.example.demo.domain.security.UserPermissionPO;
import com.example.demo.service.security.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class PermissionServiceImpl implements PermissionService {
    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 查询某用户的 角色  菜单列表   权限列表
     *
     * @param username
     * @return
     */
    @Override
    public UserPermissionPO getUserPermission(String username) {
        UserPermissionPO userPermission = getUserPermissionFromDB(username);
        return userPermission;
    }

    /**
     * 从数据库查询用户权限信息
     *
     * @param username
     * @return
     */
    private UserPermissionPO getUserPermissionFromDB(String username) {
        UserPermissionPO userPermission = permissionDao.getUserPermission(username);
        //管理员角色ID为1
        int adminRoleId = 1;
        //如果是管理员 String roleIdKey = "roleId";
        if (adminRoleId == userPermission.getRoleId()) {
            //查询所有菜单  所有权限
            Set<String> menuList = permissionDao.getAllMenu();
            Set<String> permissionList = permissionDao.getAllPermission();
            userPermission.setMenuList(menuList);
            userPermission.setPermissionList(permissionList);
        }
        return userPermission;
    }

    @Override
    public List<PermissionVO> list(PermissionVO permission) {
        return permissionDao.getList(permission);
    }

    @Override
    public PermissionVO findById(long id) {
        return permissionDao.queryById(id);
    }

    @Override
    public void add(PermissionVO permission) {
        permissionDao.save(permission);
    }

    @Override
    public void updateById(PermissionVO permission) {
        permissionDao.update(permission);
    }

    @Override
    public void delById(long id) {
        permissionDao.delete(id);
    }
}
