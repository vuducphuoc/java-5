package com.laptrinhjava5.minishop.model;

public class Product_DetailsVO {
    private Integer id;
    private Integer quantity;

    private ProductsVO product;
    private ColorsVO color;
    private SizesVO size;

    private Integer productId;
    private Integer colorId;
    private Integer sizeId;


    public Product_DetailsVO() {
    }

    public Product_DetailsVO(Integer id, Integer quantity, ProductsVO product, ColorsVO color, SizesVO size) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.color = color;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }
}
