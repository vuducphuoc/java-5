package com.laptrinhjava.ModelUtils;

import com.laptrinhjava.Entity.Account;
import com.laptrinhjava.Entity.Product;
import com.laptrinhjava.Model.AccountDTO;
import com.laptrinhjava.Model.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class AccountBeanUtil {

    public static Account dto2Entity(AccountDTO dto) {
        Account entity = new Account();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setRole(dto.isRole());
        return entity;
    }

    public static AccountDTO entity2Dto(Account entity) {
        AccountDTO dto = new AccountDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setPhone(entity.getPhone());
        dto.setRole(entity.isRole());
        return dto;
    }

    public static List<AccountDTO> listEntity2ListDto(List<Account> enityList) {
        List<AccountDTO> dtoList = new ArrayList<>();

        for (Account item : enityList) {
            dtoList.add(entity2Dto(item));
        }
        return dtoList;
    }

    public static List<Account> listDto2ListEntity(List<AccountDTO> dtoList) {
        List<Account> entityList = new ArrayList<>();
        for (AccountDTO item : dtoList) {
            entityList.add(dto2Entity(item));
        }
        return entityList;
    }
}
