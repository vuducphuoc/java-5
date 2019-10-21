package com.laptrinhjava5.minishop.entity;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
public class Product_Details implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Products product;

    @ManyToOne
    @JoinColumn(name = "colorID")
    private Colors color;

    @ManyToOne
    @JoinColumn(name = "sizeID")
    private Sizes size;

    public Product_Details() {
    }

    public Product_Details(int quantity, Products product, Colors color, Sizes size) {
        this.quantity = quantity;
        this.product = product;
        this.color = color;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }
}
