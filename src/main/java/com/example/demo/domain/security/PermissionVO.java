package com.example.demo.domain.security;

import com.example.demo.base.BaseVO;

/**
 * 权限
 */
public class PermissionVO extends BaseVO{

    /** 自定id,主要供前端展示权限列表分类排序使用. */
    private Long id;

    /** 归属菜单,前端判断并展示菜单使用 */
    private String menuCode;

    /** 菜单的中文释义 */
    private String menuName;

    /** 权限的代码/通配符,对应代码中@RequiresPermissions 的value */
    private String permissionCode;

    /** 本权限的中文释义 */
    private String permissionName;

    /** 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选 */
    private Integer requiredPermission;

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

    public Integer getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(Integer requiredPermission) {
        this.requiredPermission = requiredPermission;
    }
}
