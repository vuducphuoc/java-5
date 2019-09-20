package com.laptrinhjava.Model;

import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Entity.Detail_Product;
import com.laptrinhjava.Entity.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ProductDTO implements Serializable {

    private int id;
    private String name;
    private int price;
    private String describe;
    private String image;
    private CategoryDTO category;

    private List<DetailProductDTO> detailProductList;
    private List<SizeDTO> sizeList;
    private List<ColorDTO> colorList;
    private List<String> imageList;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String[] getImage() {
        String[] str = image.split(",");
        return str;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<DetailProductDTO> getDetailProductList() {
        return detailProductList;
    }

    public void setDetailProductList(List<DetailProductDTO> detailProductList) {
        this.detailProductList = detailProductList;
    }

    public List<SizeDTO> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<SizeDTO> sizeList) {
        this.sizeList = sizeList;
    }

    public List<ColorDTO> getColorList() {
        return colorList;
    }

    public void setColorList(List<ColorDTO> colorList) {
        this.colorList = colorList;
    }
}
