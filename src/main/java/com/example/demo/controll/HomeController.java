package com.example.demo.controll;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("userName", SecurityUtils.getSubject().getPrincipal());
        return "index";//登录后的页面
    }

    @RequestMapping("main/home.do_")
    public String backHome () {
        return "home";
    }
}