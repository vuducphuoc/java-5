package com.laptrinhjava.ModelUtils;

import com.laptrinhjava.Entity.Detail_Bill;
import com.laptrinhjava.Entity.Detail_Product;
import com.laptrinhjava.Model.DetailBillDTO;
import com.laptrinhjava.Model.DetailProductDTO;

import java.util.ArrayList;
import java.util.List;

public class DetailProductBeanUtil {

    public static Detail_Product dto2Entity(DetailProductDTO dto) {
        Detail_Product entity = new Detail_Product();
        entity.setId(dto.getId());
        entity.setNumber(dto.getNumber());
        entity.setDate_added(dto.getDate_added());
        entity.setImage(dto.getImage());

        entity.setProduct(ProductBeanUtil.dto2Entity(dto.getProduct()));
        entity.setColor(ColorBeanUtil.dto2Entity(dto.getColor()));
        entity.setSize(SizeBeanUtil.dto2Entity(dto.getSize()));
        return entity;
    }

    public static DetailProductDTO entity2Dto(Detail_Product entity) {
        DetailProductDTO dto = new DetailProductDTO();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setDate_added(entity.getDate_added());
        dto.setImage(entity.getImage());

        dto.setProduct(ProductBeanUtil.entity2Dto(entity.getProduct()));
        dto.setColor(ColorBeanUtil.entity2Dto(entity.getColor()));
        dto.setSize(SizeBeanUtil.entity2Dto(entity.getSize()));
        return dto;
    }

    public static List<DetailProductDTO> listEntity2ListDto(List<Detail_Product> enityList) {
        List<DetailProductDTO> dtoList = new ArrayList<>();

        for (Detail_Product item : enityList) {
            dtoList.add(entity2Dto(item));
        }
        return dtoList;
    }

    public static List<Detail_Product> listDto2ListEntity(List<DetailProductDTO> dtoList) {
        List<Detail_Product> entityList = new ArrayList<>();
        for (DetailProductDTO item : dtoList) {
            entityList.add(dto2Entity(item));
        }
        return entityList;
    }
}
