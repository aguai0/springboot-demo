package com.example.exception;

import com.example.shiroDemo.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description:统一异常处理
 * All Rights Reserved.
 *
 */
@RestControllerAdvice
public class ApplicationExceptionHandler {
    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result handleApplicationException(ApplicationException e){
        return new FailResult(e.getApplicationEnum());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result handleRuntimeException(RuntimeException e)throws RuntimeException{
        LOGGER.error("出错了",e);
        return new FailResult();
    }


}