package com.laptrinhjava5.minishop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Users implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private int status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Users_Roles", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "roleID"))
    private List<Roles> rolesList;

    @OneToMany(mappedBy = "user")
    private List<Bills> billsList;

    public Users() {
    }

    public Users(String name, String email, String password, int status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public Users(int id, String name, String email, String password, int status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public List<Bills> getBillsList() {
        return billsList;
    }

    public void setBillsList(List<Bills> billsList) {
        this.billsList = billsList;
    }
}
