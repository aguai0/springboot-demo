package com.example.demo.controll.security;

import com.example.demo.base.Pageable;
import com.example.demo.base.Result;
import com.example.demo.common.constants.SysConstant;
import com.example.demo.common.enums.RoleEnum;
import com.example.demo.domain.security.UserVO;
import com.example.demo.service.security.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 用户Controller
 *
 */
@RequestMapping("/security/user")
@Controller
public class UserController {


    @Resource
    UserService userService;


    @RequestMapping("/info.do_")
    public String info (Model model) {

        String email = SecurityUtils.getSubject().getPrincipal() + SysConstant.emailFix;

        UserVO user = userService.findByEmail(email);

        model.addAttribute("user", user);

        return "security/user/info";
    }


    @RequestMapping("/list.do_")
    public String list (Model model, UserVO user, Pageable pageable) {

        user.setPageable(pageable);

        Integer count = userService.count(user);
        List<UserVO> list = userService.list(user);

        model.addAttribute("user", user);
        model.addAttribute("count",count);
        model.addAttribute("pageable",pageable);
        model.addAttribute("list",list );

        return "security/user/list";
    }


    @RequestMapping("/edit.do_")
    public String edit (Model model, String email) {

        UserVO user = new UserVO();

        if(StringUtils.isNotBlank(email)){
            user = userService.findByEmail(email);
        }
        model.addAttribute("user", user);
        model.addAttribute("roles", RoleEnum.values());

        return "security/user/edit";
    }


    @RequestMapping("/save.do_")
    @ResponseBody
    public Result save (Model model, UserVO user) {

        userService.upsert(user);

        model.addAttribute("user", user);

        return Result.succeed();
    }


    @RequestMapping("/del.do_")
    @ResponseBody
    public Result del (Model model, String email) {

        userService.delByEmail(email);

        model.addAttribute("email", email);

        return Result.succeed();
    }

}
