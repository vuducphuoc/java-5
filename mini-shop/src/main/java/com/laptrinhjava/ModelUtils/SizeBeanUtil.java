package com.laptrinhjava.ModelUtils;

import com.laptrinhjava.Entity.Detail_Product;
import com.laptrinhjava.Entity.Size;
import com.laptrinhjava.Model.DetailProductDTO;
import com.laptrinhjava.Model.SizeDTO;

import java.util.ArrayList;
import java.util.List;

public class SizeBeanUtil {

    public static Size dto2Entity(SizeDTO dto) {
        Size entity = new Size();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static SizeDTO entity2Dto(Size entity) {
        SizeDTO dto = new SizeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static List<SizeDTO> listEntity2ListDto(List<Size> enityList) {
        List<SizeDTO> dtoList = new ArrayList<>();

        for (Size item : enityList) {
            dtoList.add(entity2Dto(item));
        }
        return dtoList;
    }

    public static List<Size> listDto2ListEntity(List<SizeDTO> dtoList) {
        List<Size> entityList = new ArrayList<>();
        for (SizeDTO item : dtoList) {
            entityList.add(dto2Entity(item));
        }
        return entityList;
    }
}
