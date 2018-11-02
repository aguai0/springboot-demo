package com.example.demo.common.enums;

/**
 * Description: 状态
 *
 */
public enum StatusEnum implements EnumValue {

    valid (1, "有效"),
    invalid(0, "无效"),
    delete(-1, "删除"),

    ;

    private int code;
    private String name;

    StatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    public static StatusEnum of (int code) {
        for (StatusEnum e : StatusEnum.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}
