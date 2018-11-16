package com.example.demo.controll.security;

import com.example.demo.base.Pageable;
import com.example.demo.base.Result;
import com.example.demo.domain.security.UserVO;
import com.example.demo.service.security.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * 查询用户列表
     *
     * @param userVO
     * @return
     */
    //@RequiresPermissions("user:list")
    @RequestMapping("/list.do_")
    public String listUser(Model model,UserVO userVO, Pageable pageable) {
        userVO.setPageable(pageable);

        Integer count = userService.count(userVO);
        List<UserVO> list = userService.findList(userVO);

        model.addAttribute("user",userVO);
        model.addAttribute("count",count);
        model.addAttribute("pageable",pageable);
        model.addAttribute("list",list );

        return "security/user/list";
    }

    @RequiresPermissions("user:save")
    @PostMapping("/save")
    public Result addUser(Model model,@RequestBody UserVO userVO) {

        if(userVO.getId() != null){
            userService.update(userVO);
        }else {
            userService.save(userVO);
        }

        model.addAttribute("user", userVO);
        return  Result.succeed();
    }


}
