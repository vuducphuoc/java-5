package com.laptrinhjava.ModelUtils;

import com.laptrinhjava.Entity.Category;
import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Model.CategoryDTO;
import com.laptrinhjava.Model.ColorDTO;

import java.util.ArrayList;
import java.util.List;

public class ColorBeanUtil {

    public static Color dto2Entity(ColorDTO dto) {
        Color entity = new Color();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static ColorDTO entity2Dto(Color entity) {
        ColorDTO dto = new ColorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }


    public static List<ColorDTO> listEntity2ListDto(List<Color> enityList) {
        List<ColorDTO> dtoList = new ArrayList<>();

        for (Color item : enityList) {
            dtoList.add(entity2Dto(item));
        }
        return dtoList;
    }

    public static List<Color> listDto2ListEntity(List<ColorDTO> dtoList) {
        List<Color> entityList = new ArrayList<>();
        for (ColorDTO item : dtoList) {
            entityList.add(dto2Entity(item));
        }
        return entityList;
    }
}
