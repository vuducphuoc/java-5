package com.laptrinhjava5.minishop.model;

import java.util.List;

public class SizesVO {
    private Integer id;
    private String name;

    public SizesVO() {
    }

    public SizesVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
