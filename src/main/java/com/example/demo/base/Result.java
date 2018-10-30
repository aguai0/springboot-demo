package com.example.demo.base;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 */
public class Result<T>  implements Serializable {

    private static final String SUCCESS = "操作成功";

    private static final String FAILURE = "操作失败";

    private T data;
    private String message;
    private Integer code;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Result(int code, String message) {
        this(code,message,null);
    }

    public static Result succeed() {
        return new Result(200,SUCCESS);
    }

    public static <T> Result succeed(T t) {
        return new Result(200,SUCCESS,t);
    }

    public static <T> Result succeed(String message, T obj) {
        return new Result(200,message,obj);
    }

    public static Result fail() {
        return new Result(500,FAILURE);
    }

    public static Result fail(int code, String message) {
        return new Result(code,message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}