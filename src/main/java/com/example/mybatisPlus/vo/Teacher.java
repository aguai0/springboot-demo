package com.example.mybatisPlus.vo;

//@TableName(value = "teacher")
public class Teacher {
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