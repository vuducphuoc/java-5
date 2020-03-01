package com.laptrinhjava5.minishop.model;

public class BillsVO {

    private Integer id;
    private String address;
    private String phone;
    private String notes;
    private int total;
    private int status;

    private UserVO user;

    public BillsVO() {
    }

    public BillsVO(Integer id, String address, String phone, String notes, int total, int status, UserVO user) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.notes = notes;
        this.total = total;
        this.status = status;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
