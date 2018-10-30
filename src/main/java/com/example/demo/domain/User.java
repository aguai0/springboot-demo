package com.example.demo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // mediatype 转为xml
public class User {

    private long id; // 用户的唯一标识
    private String name;
    private String password;
    private int age;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}