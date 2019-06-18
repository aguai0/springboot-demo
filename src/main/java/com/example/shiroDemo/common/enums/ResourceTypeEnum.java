package com.example.shiroDemo.common.enums;

/**
 * Description: 资源类型
 */
public enum ResourceTypeEnum {

    MEMU("menu","菜单"),
    BUTTOM("button","按钮"),

    ;

    private String name;
    private String desc;

    ResourceTypeEnum(String name, String desc) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public static ResourceTypeEnum of (String name) {
        for (ResourceTypeEnum e : ResourceTypeEnum.values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
}
