package com.laptrinhjava5.minishop.model;


import java.util.List;

public class UserVO {

    private int id;
    private String name;
    private String email;
    private String password;
    private int status;
    private Integer[] roles;

    public UserVO() {
    }

    public UserVO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserVO(int id, String name, String email, String password, int status, Integer[] roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer[] getRoles() {
        return roles;
    }

    public void setRoles(Integer[] roles) {
        this.roles = roles;
    }
}
