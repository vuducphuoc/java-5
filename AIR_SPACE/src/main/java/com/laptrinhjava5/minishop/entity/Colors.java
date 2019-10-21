package com.laptrinhjava5.minishop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Colors implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    private List<Images> imagesList;

    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    private List<Product_Details> productDetailsList;

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

    public List<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    public List<Product_Details> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<Product_Details> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }
}
