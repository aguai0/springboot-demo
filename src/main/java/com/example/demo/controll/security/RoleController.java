package com.example.demo.controll.security;

import com.example.demo.base.Pageable;
import com.example.demo.base.Result;
import com.example.demo.domain.security.RoleVO;
import com.example.demo.service.security.RoleService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description: 角色 Controller
 */
@RequestMapping("/security/role")
@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequiresPermissions(value = {"user:add", "user:update"}, logical = Logical.OR)
    @GetMapping("/getAllRoles")
    public Model getAllRoles(Model model) {
        List<RoleVO> roleVOList = roleService.getAllRoles();
        model.addAttribute("roles",roleVOList);
        return model;
    }

    /**
     * 角色列表
     *
     * @return
     */
    @RequiresPermissions("role:list")
    @GetMapping("/listRole")
    public String listRole(Model model,RoleVO roleVO, Pageable pageable) {
        roleVO.setPageable(pageable);

        Integer count = roleService.count(roleVO);
        List<RoleVO> list = roleService.findList(roleVO);

        model.addAttribute("roleVO",roleVO);
        model.addAttribute("count",count);
        model.addAttribute("pageable",pageable);
        model.addAttribute("list",list );

        return "security/role/list";
    }


    /**
     * 新增角色
     *
     * @return
     */
    @RequiresPermissions("role:add")
    @PostMapping("/addRole")
    public Result addRole(Model model ,@RequestBody RoleVO roleVO) {

        if(roleVO.getId() != null){
            roleService.update(roleVO);
        }else {
            roleService.save(roleVO);
        }

        model.addAttribute("role", roleVO);
        return  Result.succeed();
    }


    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @RequiresPermissions("role:delete")
    @PostMapping("/deleteRole")
    public Result deleteRole(@RequestBody Long roleId) {
        roleService.delByRoleId(roleId);
        return Result.succeed();
    }
}
