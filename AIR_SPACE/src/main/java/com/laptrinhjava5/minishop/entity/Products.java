package com.laptrinhjava5.minishop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Products implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String describes;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Categorys category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Product_Details> productDetailsList;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Images> imagesList;

    public Products() {
    }

    public Products(String name, int price, String describes, Categorys category) {
        this.name = name;
        this.price = price;
        this.describes = describes;
        this.category = category;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Categorys getCategory() {
        return category;
    }

    public void setCategory(Categorys category) {
        this.category = category;
    }

    public List<Product_Details> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<Product_Details> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }

    public List<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
