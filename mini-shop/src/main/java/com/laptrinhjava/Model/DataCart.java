package com.laptrinhjava.Model;

import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Entity.Product;
import com.laptrinhjava.Entity.Size;

public class DataCart {
    private int idProduct;
    private int idSize;
    private int idColor;

    private ProductDTO product;
    private DetailProductDTO detailProduct;
    private SizeDTO size;
    private ColorDTO color;

    private int quantity;
    private int totalPrice;


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public SizeDTO getSize() {
        return size;
    }

    public void setSize(SizeDTO size) {
        this.size = size;
    }

    public ColorDTO getColor() {
        return color;
    }

    public void setColor(ColorDTO color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        int total = product.getPrice() * quantity;
        return total;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public DetailProductDTO getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(DetailProductDTO detailProduct) {
        this.detailProduct = detailProduct;
    }
}
