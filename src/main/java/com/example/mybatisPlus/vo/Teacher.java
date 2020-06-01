package com.example.mybatisPlus.vo;

import java.io.Serializable;

//@TableName(value = "teacher")
public class Teacher implements Serializable{
    private static final long serialVersionUID = 591460844118135217L;
    private int id;

    private String teacherName;

    private String teacherPwd;

    public int getId() {
        return id;
    }


    public Teacher() {
    }

    public Teacher(int id) {
        this.id = id;
    }

    public Teacher(int id, String teacherName, String teacherPwd) {
        this.id = id;
        this.teacherName = teacherName;
        this.teacherPwd = teacherPwd;
    }

    public Teacher setId(int id) {
        this.id = id;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Teacher setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public Teacher setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
        return this;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "id=" + id +
        ", teacherName='" + teacherName + '\'' +
        ", teacherPwd='" + teacherPwd + '\'' +
        '}';
    }
}