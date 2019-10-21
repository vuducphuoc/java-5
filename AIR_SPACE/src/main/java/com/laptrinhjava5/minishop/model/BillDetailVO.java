package com.laptrinhjava5.minishop.model;

public class BillDetailVO {

    private Integer id;
    private Integer quantity;
    private Product_DetailsVO product;
    private BillsVO bill;

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

    public Product_DetailsVO getProduct() {
        return product;
    }

    public void setProduct(Product_DetailsVO product) {
        this.product = product;
    }

    public BillsVO getBill() {
        return bill;
    }

    public void setBill(BillsVO bill) {
        this.bill = bill;
    }
}
