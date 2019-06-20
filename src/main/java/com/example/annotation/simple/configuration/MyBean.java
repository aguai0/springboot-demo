package com.example.annotation.simple.configuration;


public class MyBean {

    String name;

    public MyBean(String name) {
        this.name = name;
    }

    public MyBean(){
        System.out.println("generate MyBean Instance");
    }

    public void init(){
        System.out.println("MyBean Resources Initialized");
    }

    @Override
    public String toString() {
        return "MyBean{" +
        "name='" + name + '\'' +
        '}';
    }
}