package com.laptrinhjava5.model;

public class RecordsDTO {
    int id;
    boolean type;
    String reason;
    String dateCreate;
    StaffsDTO staff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public StaffsDTO getStaff() {
        return staff;
    }

    public void setStaff(StaffsDTO staff) {
        this.staff = staff;
    }
}
