package com.laptrinhjava5.minishop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bill_Details implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product_Details product;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bills bill;

    public Bill_Details() {
    }

    public Bill_Details(int quantity, Product_Details product, Bills bill) {
        this.quantity = quantity;
        this.product = product;
        this.bill = bill;
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

    public Product_Details getProduct() {
        return product;
    }

    public void setProduct(Product_Details product) {
        this.product = product;
    }

    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }
}
