package com.laptrinhjava5.minishop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Sizes implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    List<Product_Details> productDetailsList;

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

    public List<Product_Details> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<Product_Details> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }
}
