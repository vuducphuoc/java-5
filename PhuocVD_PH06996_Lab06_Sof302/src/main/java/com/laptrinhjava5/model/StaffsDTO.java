package com.laptrinhjava5.model;

import java.util.List;

public class StaffsDTO {

    int id;
    String name;
    boolean gender;
    String birthday;
    String photo;
    String email;
    String phone;
    int salary;
    String notes;
    DepartsDTO departsDTO;
    List<RecordsDTO> recordsDTOList;

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DepartsDTO getDepartsDTO() {
        return departsDTO;
    }

    public void setDepartsDTO(DepartsDTO departsDTO) {
        this.departsDTO = departsDTO;
    }

    public List<RecordsDTO> getRecordsDTOList() {
        return recordsDTOList;
    }

    public void setRecordsDTOList(List<RecordsDTO> recordsDTOList) {
        this.recordsDTOList = recordsDTOList;
    }
}
