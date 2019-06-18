package com.example.shiroDemo.domain.security.vo;

import com.example.shiroDemo.base.BaseVO;

public class PermissionVo extends BaseVO {

    private Long id;
    private String menuCode;
    private String menuName;
    private String permissionCode;
    private String permissionName;
    private Integer requiredPerm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getRequiredPerm() {
        return requiredPerm;
    }

    public void setRequiredPerm(Integer requiredPerm) {
        this.requiredPerm = requiredPerm;
    }
}