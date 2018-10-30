package com.example.demo.controll;

import com.example.demo.base.Result;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    public ModelAndView login(Model model){
        model.addAttribute("title", "登录页面");
        return new ModelAndView("login", "userModel", model);
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public Result userLogin( User user){
        user = userRepository.login(user);
        if(user==null){
            return Result.fail();
        }
        return Result.succeed(user);
    }

    @RequestMapping("/main")
    public ModelAndView main(Model model,String userName){
        model.addAttribute("title", "主页面");
        model.addAttribute("username",userName);
        return new ModelAndView("main", "userModel", model);
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public Result checkUser(String user){
        if(userRepository.checkUser(user)){
            return Result.succeed();
        }else {
            return Result.fail();
        }
    }

    @RequestMapping("/back")
    public ModelAndView back(Model model){
        model.addAttribute("title", "主页面");
        return new ModelAndView("back", "userModel", model);
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }


    @RequestMapping("/doRegister")
    @ResponseBody
    public Result register(String name,String password){

        userRepository.register(new User(name,password));
        return Result.succeed();
    }
}