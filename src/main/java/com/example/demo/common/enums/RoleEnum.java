package com.example.demo.common.enums;

/**
 * Description: 角色
 */
public enum RoleEnum {

    common ("common", "一般用户", "index:homePage"),
    index_admin("index_admin", "前台管理员", "index:homePage,index:home"),
    back_admin ("back_admin", "后台管理员", "index:homePage,index:home,demo:back,back:compute,back:view,back:warning"),
    super_admin("super_admin", "超级管理员", "index:homePage,index:home,demo:back,back:compute,back:view,back:warning,back:security,back:system,back:check"),

    ;

    private String roleCode;
    private String roleName;
    private String permission;

    RoleEnum(String roleCode, String roleName, String permission) {
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.permission = permission;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getPermission() {
        return permission;
    }

    public static RoleEnum of (String roleCode) {
        for (RoleEnum e : RoleEnum.values()) {
            if (e.getRoleCode().equals(roleCode)) {
                return e;
            }
        }
        return null;
    }

    public static String getPermissionByRoleCode(String roleCode) {
        for (RoleEnum e : RoleEnum.values()) {
            if (e.getRoleCode().equals(roleCode)) {
                return e.getPermission();
            }
        }
        return null;
    }
}
