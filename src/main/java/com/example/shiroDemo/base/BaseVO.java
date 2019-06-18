package com.example.shiroDemo.base;

import java.io.Serializable;
import java.util.Date;

public class BaseVO implements Serializable {
   // @TableField(exist = false)
    private Pageable pageable;

    // 创建时间
    protected Date createTime;
    // 创建人id
    protected String createName;
    // 修改时间
    protected Date modifyTime;
    // 修改人id
    protected String modifyName;

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyName() {
        return modifyName;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }
}