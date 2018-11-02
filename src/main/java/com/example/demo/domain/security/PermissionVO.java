package com.example.demo.domain.security;

import com.example.demo.base.BaseVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限
 */
public class PermissionVO extends BaseVO{

    private Long id;

    private String resourceCode;

    private String resourceName;

    private String resourceType;

    private String parentCode;

    private Integer resourceLevel;

    private String permissionCode;

    private Integer resourceTag;

    private String resourceUrl;

    private Integer sort;

    private Integer status;

    private List<PermissionVO> childList = new ArrayList<>();


    public void addChild (PermissionVO permissionVO) {
        childList.add(permissionVO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(Integer resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public Integer getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(Integer resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<PermissionVO> getChildList() {
        return childList;
    }

    public void setChildList(List<PermissionVO> childList) {
        this.childList = childList;
    }
}
