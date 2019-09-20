package com.laptrinhjava.ModelUtils;

import com.laptrinhjava.Entity.Product;
import com.laptrinhjava.Model.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductBeanUtil {

    public static Product dto2Entity(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDescribe(dto.getDescribe());
        entity.setCategory(CategoryBeanUtil.dto2Entity(dto.getCategory()));
        entity.setImage(dto.getImage().toString());
        return entity;
    }

    public static ProductDTO entity2Dto(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDescribe(entity.getDescribe());
        dto.setCategory(CategoryBeanUtil.entity2Dto(entity.getCategory()));
        dto.setImage(entity.getImage());
        return dto;
    }

    public static List<ProductDTO> listEntity2ListDto(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product item : productList) {
            productDTOList.add(entity2Dto(item));
        }
        return productDTOList;
    }

    public static List<Product> listDto2ListEntity(List<ProductDTO> productDTOList) {
        List<Product> productList = new ArrayList<>();
        for (ProductDTO item : productDTOList) {
            productList.add(dto2Entity(item));
        }
        return productList;
    }
}
