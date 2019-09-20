package com.laptrinhjava.ModelUtils;

import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Entity.Detail_Bill;
import com.laptrinhjava.Model.ColorDTO;
import com.laptrinhjava.Model.DetailBillDTO;

import java.util.ArrayList;
import java.util.List;

public class DetailBillBeanUtil {

    public static Detail_Bill dto2Entity(DetailBillDTO dto) {
        Detail_Bill entity = new Detail_Bill();
        entity.setId(dto.getId());
        entity.setNumber(dto.getNumber());
        entity.setPrice(dto.getPrice());
        entity.setBill(BillBeanUtil.dto2Entity(dto.getBillDTO()));
        entity.setDetail_product(DetailProductBeanUtil.dto2Entity(dto.getDetailProduct()));
        return entity;
    }

    public static DetailBillDTO entity2Dto(Detail_Bill entity) {
        DetailBillDTO dto = new DetailBillDTO();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setPrice(entity.getPrice());
        dto.setBillDTO(BillBeanUtil.entity2Dto(entity.getBill()));
        dto.setDetailProduct(DetailProductBeanUtil.entity2Dto(entity.getDetail_product()));
        return dto;
    }

    public static List<DetailBillDTO> listEntity2ListDto(List<Detail_Bill> enityList) {
        List<DetailBillDTO> dtoList = new ArrayList<>();

        for (Detail_Bill item : enityList) {
            dtoList.add(entity2Dto(item));
        }
        return dtoList;
    }

    public static List<Detail_Bill> listDto2ListEntity(List<DetailBillDTO> dtoList) {
        List<Detail_Bill> entityList = new ArrayList<>();
        for (DetailBillDTO item : dtoList) {
            entityList.add(dto2Entity(item));
        }
        return entityList;
    }
}
