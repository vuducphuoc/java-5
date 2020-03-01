package com.laptrinhjava5.minishop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bills implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String phone;
    private String notes;
    private int status;
    private int total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Bills() {
    }

    public Bills(String address, String phone, String notes, int status, int total, Users user) {
        this.address = address;
        this.phone = phone;
        this.notes = notes;
        this.status = status;
        this.total = total;
        this.user = user;
    }

    public Bills(Integer id, String address, String phone, String notes, int status, int total, Users user) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.notes = notes;
        this.status = status;
        this.total = total;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
