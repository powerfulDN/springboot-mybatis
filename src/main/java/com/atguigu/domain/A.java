package com.atguigu.domain;

import java.io.Serializable;

public class A implements Serializable {
    private String username;
    private String pwd;
    private String name;

    public A() {
    }

    public A(String username, String pwd, String name) {
        this.username = username;
        this.pwd = pwd;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
