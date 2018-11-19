package com.example.demo.base;

import java.io.Serializable;

public class Pageable implements Serializable {
    private static final long serialVersionUID = -8906152712547437506L;

    private Integer page = 0;//从第0页开始

    private Integer size = 10;//每页显示多少条

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStart() {
        return size * page;
    }

    public Integer getEnd() {
        return size * (page+1);
    }
}