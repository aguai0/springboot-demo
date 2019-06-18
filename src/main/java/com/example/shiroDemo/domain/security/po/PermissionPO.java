package com.example.shiroDemo.domain.security.po;

import com.example.shiroDemo.domain.security.vo.PermissionVo;

import java.util.List;

/**
 * 权限
 */
public class PermissionPO {

    private Long permissionId;

    /** 本权限的中文释义 */
    private String permissionName;

    private String menuName;

    private List<PermissionVo> permissions;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<PermissionVo> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionVo> permissions) {
        this.permissions = permissions;
    }
}
