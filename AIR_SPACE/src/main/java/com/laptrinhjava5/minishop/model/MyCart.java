package com.laptrinhjava5.minishop.model;

public class MyCart {

    private Integer productID;
    private Integer colorID;
    private Integer sizeID;

    private ProductsVO product;
    private ColorsVO color;
    private SizesVO size;

    private Integer quantity;
    private Integer total;

    public MyCart() {
    }

    public MyCart(Integer productID, Integer colorID, Integer sizeID, Integer quantity) {
        this.productID = productID;
        this.colorID = colorID;
        this.sizeID = sizeID;
        this.quantity = quantity;
    }

    public MyCart(Integer productID, Integer colorID, Integer sizeID, ProductsVO product, ColorsVO color, SizesVO size, Integer quantity) {
        this.productID = productID;
        this.colorID = colorID;
        this.sizeID = sizeID;
        this.product = product;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public Integer getSizeID() {
        return sizeID;
    }

    public void setSizeID(Integer sizeID) {
        this.sizeID = sizeID;
    }

    public ProductsVO getProduct() {
        return product;
    }

    public void setProduct(ProductsVO product) {
        this.product = product;
    }

    public ColorsVO getColor() {
        return color;
    }

    public void setColor(ColorsVO color) {
        this.color = color;
    }

    public SizesVO getSize() {
        return size;
    }

    public void setSize(SizesVO size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return quantity*product.getPrice();
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
