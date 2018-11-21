package com.example.demo.domain.security.po;

import java.io.Serializable;
import java.util.List;

public class UserPermissionPO implements Serializable{

    private Long roleId;

    private String roleName;

    private List<UserPo> users;

    private List<MenuPO> menus;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserPo> getUsers() {
        return users;
    }

    public void setUsers(List<UserPo> users) {
        this.users = users;
    }

    public List<MenuPO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuPO> menus) {
        this.menus = menus;
    }
}