package com.example.demo.service.security.impl;

import com.example.demo.common.enums.StatusEnum;
import com.example.demo.dao.security.UserDAO;
import com.example.demo.domain.security.UserVO;
import com.example.demo.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    public Integer count(UserVO collect) {
        int count = userDAO.count(collect);
        return count;
    }


    public List<UserVO> list (UserVO user) {
        List<UserVO> list = userDAO.findList(user);
        return list;
    }


    public UserVO findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    public void add(String email) {
        UserVO user = getDefaultUser(email);
        /*if (email.contains("admin")) {
            user.setRoles(RoleEnum.super_admin.getRoleCode());
        } else {
            user.setRoles(RoleEnum.index_admin.getRoleCode());
        }*/
        this.add(user);
    }


    private void add(UserVO record) {
        userDAO.insertWithNotExist(record);
    }

    public void upsert(UserVO record) {
        userDAO.upsert(record);
    }

    public void delByEmail(String email) {
        UserVO user = new UserVO();
        user.setEmail(email);
        user.setStatus(StatusEnum.delete.getCode());
        userDAO.updateByEmail(user);
    }


    public Set<String> findPermissions (String email) {

        Set<String> set = new HashSet<>();

       /* UserVO user = userDAO.findByEmail(email);
        String roles = user.getRoles();

        if (StringUtils.isNotBlank(roles)) {
            String[] roleCodes = roles.split(",");
            for (String roleCode : roleCodes) {
                RoleVO role =roleDAO.findByCode(roleCode);
                String pemissions = role.getPermissions();
                String pemissions = RoleEnum.getPermissionByRoleCode(roleCode);
                if (StringUtils.isNotBlank(pemissions)) {
                    set.addAll(Arrays.asList(pemissions.split(",")));
                }
            }
        }*/

        return set;
    }


    private UserVO getDefaultUser (String email) {
        UserVO user = new UserVO();
        user.setEmail(email);
        user.setCreateName(email);
        user.setModifyName(email);
        return user;
    }
}