package com.example.demo.domain.security.po;

import java.util.Set;

/**
 * 权限
 */
public class MenuPO {

    /** 归属菜单,前端判断并展示菜单使用 */
    private String menuCode;

    /** 菜单的中文释义 */
    private String menuName;

    private Set<PermissionPO> permissions;

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

    public Set<PermissionPO> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionPO> permissions) {
        this.permissions = permissions;
    }
}
