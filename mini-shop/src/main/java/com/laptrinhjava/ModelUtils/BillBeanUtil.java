package com.laptrinhjava.ModelUtils;

import com.laptrinhjava.Entity.Account;
import com.laptrinhjava.Entity.Bill;
import com.laptrinhjava.Model.AccountDTO;
import com.laptrinhjava.Model.BillDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class BillBeanUtil {

    public static Bill dto2Entity(BillDTO dto) {
        Bill entity = new Bill();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setStatus(dto.isStatus());
        entity.setDate_created(dto.getDate_created());
        entity.setAccount(AccountBeanUtil.dto2Entity(dto.getAccount()));
        return entity;
    }

    public static BillDTO entity2Dto(Bill entity) {
        BillDTO dto = new BillDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setStatus(entity.isStatus());
        dto.setDate_created(entity.getDate_created());
        dto.setAccount(AccountBeanUtil.entity2Dto(entity.getAccount()));
        return dto;
    }

    public static List<BillDTO> listEntity2ListDto(List<Bill> enityList) {
        List<BillDTO> dtoList = new ArrayList<>();

        for (Bill item : enityList) {
            dtoList.add(entity2Dto(item));
        }
        return dtoList;
    }

    public static List<Bill> listDto2ListEntity(List<BillDTO> dtoList) {
        List<Bill> entityList = new ArrayList<>();
        for (BillDTO item : dtoList) {
            entityList.add(dto2Entity(item));
        }
        return entityList;
    }

}
