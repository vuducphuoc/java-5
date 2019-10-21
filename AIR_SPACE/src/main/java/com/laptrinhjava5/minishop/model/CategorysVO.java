package com.laptrinhjava5.minishop.model;

import java.util.List;

public class CategorysVO {

    private Integer id;
    private String name;

    private List<ProductsVO> productsList;

    public CategorysVO() {
    }

    public CategorysVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategorysVO(Integer id, String name, List<ProductsVO> productsList) {
        this.id = id;
        this.name = name;
        this.productsList = productsList;
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

    public List<ProductsVO> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductsVO> productsList) {
        this.productsList = productsList;
    }
}
