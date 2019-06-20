package com.example.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test/exception")
public class MyExceptionHandlerController {

    @RequestMapping(value = "orgs", method = RequestMethod.GET)
    @ResponseBody
    public String getOrgs ()  {

        return "请求controller测试";
    }

    @ExceptionHandler(NullReqException.class)
    public String handleNullOrgException() {
        return "无组织机构相关数据！";
    }
}