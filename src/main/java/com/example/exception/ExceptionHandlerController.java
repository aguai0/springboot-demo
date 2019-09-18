package com.example.exception;

import com.example.shiroDemo.base.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(value = NullReqException.class)
    public String handleNullReqException(){
        System.out.println("异常处理...");
        return "error";
    }

    @ExceptionHandler(value = Exception.class)
    public Result handleException(){
        return Result.fail(400,"系统异常");
    }
}