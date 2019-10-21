package com.laptrinhjava5.minishop.model;

import java.util.List;

public class ImagesVO {

    private Integer id;
    private String name;
    private Integer colorId;
    private ColorsVO color;
    private ProductsVO product;

    public ImagesVO() {
    }

    public ImagesVO(Integer id, String name, Integer colorId) {
        this.id = id;
        this.name = name;
        this.colorId = colorId;
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

    public ColorsVO getColor() {
        return color;
    }

    public void setColor(ColorsVO color) {
        this.color = color;
    }

    public ProductsVO getProduct() {
        return product;
    }

    public void setProduct(ProductsVO product) {
        this.product = product;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }
}
