package com.example.shiroDemo.controll.security;

import com.example.shiroDemo.base.Pageable;
import com.example.shiroDemo.base.Result;
import com.example.shiroDemo.domain.security.po.PermissionPO;
import com.example.shiroDemo.domain.security.po.UserPermissionPO;
import com.example.shiroDemo.domain.security.vo.RoleVO;
import com.example.shiroDemo.service.security.PermissionService;
import com.example.shiroDemo.service.security.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 角色 Controller
 */
@RequestMapping("/security/role")
@Controller
public class RoleController {
    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    RoleService roleService;

    @Resource
    private PermissionService permissionService;

/*    @RequiresPermissions(value = {"user:add", "user:update"}, logical = Logical.OR)
    @GetMapping("/getAllRoles")
    public Model getAllRoles(Model model) {
        List<RoleVO> roleVOList = roleService.getAllRoles();
        model.addAttribute("roles",roleVOList);
        return model;
    }*/

    /**
     * 角色列表
     *
     * @return
     */
    //@RequiresPermissions("role:list")
    @RequestMapping("/list.do_")
    public String listRole(Model model,Pageable pageable) {
        RoleVO roleVO = new RoleVO();
        roleVO.setPageable(pageable);

        Integer count = roleService.count();
        List<UserPermissionPO> list = roleService.findList();
        model.addAttribute("count",count);
        model.addAttribute("pageable",pageable);
        model.addAttribute("list",list );

        return "security/role/list";
    }

    @RequestMapping("/edit.do_")
    public String edit(Model model,String id){

        if(id!=null){
            RoleVO roleVO = roleService.queryById(Long.valueOf(id));
            model.addAttribute("role",roleVO);
        }else{
            model.addAttribute("role",new RoleVO());
        }
        List<PermissionPO> menus = permissionService.getAllPermission();
        model.addAttribute("menus",menus);

        return "security/role/edit";
    }

    /**
     * 新增角色
     *
     * @return
     */
    //@RequiresPermissions("role:add")
    @RequestMapping("/save.do_")
    @ResponseBody
    public Result addRole(Model model ,RoleVO roleVO) {

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
   // @RequiresPermissions("role:delete")
    @PostMapping("/deleteRole")
    public Result deleteRole(@RequestBody Long roleId) {
        roleService.delByRoleId(roleId);
        return Result.succeed();
    }
}
