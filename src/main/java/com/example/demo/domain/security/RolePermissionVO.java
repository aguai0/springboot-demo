package com.example.demo.domain.security;

import com.example.demo.base.BaseVO;

public class RolePermissionVO extends BaseVO{

    /** 角色ID */
    private Integer roleId;

    /** 权限ID */
    private Integer permissionId;

    private Integer status;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}