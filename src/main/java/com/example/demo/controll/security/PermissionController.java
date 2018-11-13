package com.example.demo.controll.security;


import com.example.demo.base.Result;
import com.example.demo.domain.security.PermissionVO;
import com.example.demo.service.security.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@RequestMapping("/security/permission")
@Controller
public class PermissionController {

    @Resource
    private PermissionService permissionService;


    @RequestMapping("/list.do_")
    public String list (Model model, PermissionVO permission) {

        List<PermissionVO> list = permissionService.list(permission);

        model.addAttribute("permission", permission);
        model.addAttribute("list",list );

        return "security/permission/list";
    }

    @RequestMapping("/edit.do_")
    public String edit (Model model, String id) {

        PermissionVO permission = new PermissionVO();
       // permission.setResourceType(ResourceTypeEnum.MEMU.getName());

        if(StringUtils.isNotBlank(id)){
            permission = permissionService.findById(Long.parseLong(id));
        }
        model.addAttribute("permission", permission);

        return "security/permission/edit";
    }


    @RequestMapping("/save.do_")
    @ResponseBody
    public Result save (PermissionVO permission) {

        if (permission.getId() == null) {
            permissionService.add(permission);
        } else {
            permissionService.updateById(permission);
        }

        return Result.succeed();
    }


    @RequestMapping("/del.do_")
    @ResponseBody
    public Result del (String id) {

        permissionService.delById(Long.parseLong(id));

        return Result.succeed();
    }
}
