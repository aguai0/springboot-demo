package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(value = NullReqException.class)
    public String handleNullReqException(){
        System.out.println("异常处理...");
        return "error";
    }
}