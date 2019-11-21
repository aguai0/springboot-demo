package com.example.exception;

/**
 * Description:
 * All Rights Reserved.
 *
 */
public enum ApplicationEnum {

    success(200,"执行成功"),
    fail(400,"执行失败");

    private int code;
    private String msg;

    ApplicationEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}