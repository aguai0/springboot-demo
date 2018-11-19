package com.example.demo.domain.security;


import com.example.demo.base.BaseVO;

/**
 * Description: 角色
 */
public class RoleVO extends BaseVO {

    private Long id;
    private String roleName;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
