package com.laptrinhjava5.model;

import java.util.List;

public class DepartsDTO {
    int id;
    String name;
    List<StaffsDTO> staffsDTOList;

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

    public List<StaffsDTO> getStaffsDTOList() {
        return staffsDTOList;
    }

    public void setStaffsDTOList(List<StaffsDTO> staffsDTOList) {
        this.staffsDTOList = staffsDTOList;
    }
}
