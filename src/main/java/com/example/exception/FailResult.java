package com.example.exception;

import com.example.shiroDemo.base.Result;

/**
 * Description:
 * All Rights Reserved.
 *
 */
public class FailResult extends Result {
    public FailResult() {
        setStatus(-1);
        setCode(ApplicationEnum.fail.getCode());
        setMsg(ApplicationEnum.fail.getMsg());
    }

    public FailResult(ApplicationEnum applicationEnum) {
        setStatus(-1);
        setCode(applicationEnum.getCode());
        setMsg(applicationEnum.getMsg());
    }
}