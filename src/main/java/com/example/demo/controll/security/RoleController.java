package com.example.demo.controll.security;

import com.example.demo.common.enums.RoleEnum;
import com.example.demo.service.security.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Description: 角色 Controller
 */
@RequestMapping("/security/role")
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;


    @RequestMapping("/list.do_")
    public String list (Model model) {

        model.addAttribute("list", RoleEnum.values() );

        return "security/role/list";
    }
}
