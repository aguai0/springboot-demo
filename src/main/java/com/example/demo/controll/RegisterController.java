package com.example.demo.controll;

import com.example.demo.base.Result;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }


    @RequestMapping("/doRegister")
    @ResponseBody
    public Result register(String name, String password){

        userRepository.register(new User(name,password));
        return Result.succeed();
    }
}