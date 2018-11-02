package com.example.demo.service.impl.security;

import com.example.demo.common.enums.StatusEnum;
import com.example.demo.dao.security.PermissionDAO;
import com.example.demo.domain.security.PermissionVO;
import com.example.demo.service.security.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDAO permissionDAO;

    @Override
    public List<PermissionVO> list(PermissionVO permission) {
        return permissionDAO.findList(permission);
    }

    @Override
    public PermissionVO findById(long id) {
        return permissionDAO.findById(id);
    }

    @Override
    public void add(PermissionVO permission) {
        permissionDAO.insert(permission);
    }

    @Override
    public void updateById(PermissionVO permission) {
        permissionDAO.updateById(permission);
    }

    @Override
    public void delById(long id) {
        PermissionVO permission = new PermissionVO();
        permission.setId(id);
        permission.setStatus(StatusEnum.delete.getCode());
        permissionDAO.updateById(permission);
    }

    public PermissionVO getMenu(){

        PermissionVO query = new PermissionVO();
        query.setResourceTag(1);
        query.setStatus(StatusEnum.valid.getCode());

        List<PermissionVO> permissionList = permissionDAO.findList(query);

        PermissionVO permissionVO = new PermissionVO();
        permissionVO.setResourceCode("0");

        tree(permissionVO, permissionList);

        return permissionVO;
    }

    private void tree (PermissionVO permissionVO, List<PermissionVO> permissionList) {
        for(PermissionVO p : permissionList){
            if(p.getParentCode().equals(permissionVO.getResourceCode())){
                permissionVO.addChild(p);
                if (StringUtils.isBlank(p.getResourceUrl())){
                    p.setResourceUrl("javascript:;");
                }
                tree(p, permissionList);
            }
        }
    }
}