package com.laptrinhjava5.dto;

import com.laptrinhjava5.entity.Users;
import com.laptrinhjava5.model.UsersDTO;

public class UsersBeanUtil {

    public static UsersDTO entity2Dto(Users entity) {
        UsersDTO dto = new UsersDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setFullname(entity.getFullname());
        return dto;
    }

    public static Users dto2Entity(UsersDTO dto) {
        Users entity = new Users();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFullname(dto.getFullname());
        return entity;
    }
}
