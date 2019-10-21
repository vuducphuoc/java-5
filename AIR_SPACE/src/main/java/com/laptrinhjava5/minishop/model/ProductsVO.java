package com.laptrinhjava5.minishop.model;

import java.util.List;

public class ProductsVO {

    private Integer id;
    private String name;
    private Integer price;
    private String describes;
    private CategorysVO category;
    private List<Product_DetailsVO> productDetailsList;
    private List<ImagesVO> imagesList;
    private List<ColorsVO> colorsList;
    private List<SizesVO> sizesList;
    private Integer categoryId;

    public ProductsVO() {
    }

    public ProductsVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductsVO(Integer id, String name, Integer price, String describes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describes = describes;
    }

    public ProductsVO(Integer id, String name, Integer price, String describes, CategorysVO category, List<ImagesVO> imagesList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describes = describes;
        this.category = category;
        this.imagesList = imagesList;
    }

    public ProductsVO(Integer id, String name, Integer price, String describes, List<ImagesVO> imagesList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describes = describes;
        this.imagesList = imagesList;
    }

    public ProductsVO(Integer id, String name, Integer price, String describes, CategorysVO category, List<Product_DetailsVO> productDetailsList, List<ImagesVO> imagesList, List<ColorsVO> colorsList, List<SizesVO> sizesList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describes = describes;
        this.category = category;
        this.productDetailsList = productDetailsList;
        this.imagesList = imagesList;
        this.colorsList = colorsList;
        this.sizesList = sizesList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public CategorysVO getCategory() {
        return category;
    }

    public void setCategory(CategorysVO category) {
        this.category = category;
    }

    public List<Product_DetailsVO> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<Product_DetailsVO> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }

    public List<ImagesVO> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<ImagesVO> imagesList) {
        this.imagesList = imagesList;
    }

    public List<ColorsVO> getColorsList() {
        return colorsList;
    }

    public void setColorsList(List<ColorsVO> colorsList) {
        this.colorsList = colorsList;
    }

    public List<SizesVO> getSizesList() {
        return sizesList;
    }

    public void setSizesList(List<SizesVO> sizesList) {
        this.sizesList = sizesList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
