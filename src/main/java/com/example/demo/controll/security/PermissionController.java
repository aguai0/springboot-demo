package com.example.demo.controll.security;


import com.example.demo.base.Result;
import com.example.demo.domain.security.PermissionVO;
import com.example.demo.service.security.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@RequestMapping("/security/permission")
@Controller
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    /**
     * 查询所有权限, 给角色分配权限时调用
     *
     * @return
     */
    @RequiresPermissions("role:list")
    @GetMapping("/listAllPermission")
    public Result listAllPermission(Model model) {
        List<PermissionVO> permissionVOs = permissionService.listAllPermission();
        model.addAttribute("permissions",permissionVOs);
        return Result.succeed();
    }


}
