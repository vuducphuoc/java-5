package com.laptrinhjava.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DETAIL_PRODUCT")
public class Detail_Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    @OneToOne
    @JoinColumn(name = "ID_SIZE")
    private Size size;

    @OneToOne
    @JoinColumn(name = "ID_COLOR")
    private Color color;

    @Column(name = "NUMBER")
    private int number;

    @Column(name = "DATE_ADDED")
    private String date_added;

    @Column(name = "IMAGE")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
