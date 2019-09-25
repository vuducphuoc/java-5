package com.laptrinhjava5.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Departs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @OneToMany(mappedBy = "departs")
    List<Staffs> staffsList;

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

    public List<Staffs> getStaffsList() {
        return staffsList;
    }

    public void setStaffsList(List<Staffs> staffsList) {
        this.staffsList = staffsList;
    }
}
