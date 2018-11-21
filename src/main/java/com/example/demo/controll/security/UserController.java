package com.example.demo.controll.security;

import com.example.demo.base.Pageable;
import com.example.demo.base.Result;
import com.example.demo.domain.security.vo.RoleVO;
import com.example.demo.domain.security.vo.UserVO;
import com.example.demo.service.security.RoleService;
import com.example.demo.service.security.UserService;
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

    @Resource
    RoleService roleService;

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

    @RequestMapping("/edit.do_")
    public String edit(Model model,Long id){
        UserVO user = new UserVO();
        if(id!=null){
            user = userService.queryById(id);
        }
        model.addAttribute("user",user);
        List<RoleVO> roles = roleService.getAllRoles();
        model.addAttribute("roles",roles);

        return "security/user/edit";
    }

    //@RequiresPermissions("user:save")
    @RequestMapping("/save.do_")
    @ResponseBody
    public Result addUser(Model model,UserVO userVO) {

        if(userVO.getId() != null){
            userService.update(userVO);
        }else {
            UserVO user = userService.findByName(userVO.getUserName());
            if(user!=null){
                return  Result.fail(403,"用户名已经存在");
            }
            userService.save(userVO);
        }

        model.addAttribute("user", userVO);
        return  Result.succeed();
    }

    @RequestMapping("/del.do_")
    @ResponseBody
    public Result del (Model model, Long id) {

        userService.deleteById(id);

        model.addAttribute("id", id);

        return Result.succeed();
    }
}
