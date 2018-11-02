package com.example.demo.domain.security;

import com.example.demo.base.BaseVO;
import com.example.demo.common.enums.RoleEnum;

/**
 * Description: 用户
 */
public class UserVO extends BaseVO {

    private Long id;

    private String email;
    private String name;
    private String mobile;
    private String password;

    private String roles;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleDesc () {
        RoleEnum e = RoleEnum.of(this.roles);
        if (e != null) {
            return e.getRoleName();
        } else {
            return "";
        }
    }

}
