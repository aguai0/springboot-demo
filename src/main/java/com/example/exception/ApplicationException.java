package com.example.exception;

/**
 * Description:
 * All Rights Reserved.
 *
 */
public class ApplicationException extends RuntimeException{
    private ApplicationEnum applicationEnum;

    public ApplicationException(ApplicationEnum applicationEnum) {
        super(applicationEnum.getMsg());
        this.applicationEnum = applicationEnum;
    }

    public ApplicationEnum getApplicationEnum() {
        return applicationEnum;
    }
}