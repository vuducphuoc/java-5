package com.laptrinhjava.ModelUtils;

import com.laptrinhjava.Entity.Bill;
import com.laptrinhjava.Entity.Category;
import com.laptrinhjava.Model.BillDTO;
import com.laptrinhjava.Model.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryBeanUtil {

    public static Category dto2Entity(CategoryDTO dto) {
        Category entity = new Category();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static CategoryDTO entity2Dto(Category entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static List<CategoryDTO> listEntity2ListDto(List<Category> enityList) {
        List<CategoryDTO> dtoList = new ArrayList<>();

        for (Category item : enityList) {
            dtoList.add(entity2Dto(item));
        }
        return dtoList;
    }

    public static List<Category> listDto2ListEntity(List<CategoryDTO> dtoList) {
        List<Category> entityList = new ArrayList<>();
        for (CategoryDTO item : dtoList) {
            entityList.add(dto2Entity(item));
        }
        return entityList;
    }
}
