package com.laptrinhjava5.dto;

import com.laptrinhjava5.entity.Staffs;
import com.laptrinhjava5.entity.Users;
import com.laptrinhjava5.model.StaffsDTO;
import com.laptrinhjava5.model.UsersDTO;

public class StaffsBeanUtil {

    public static StaffsDTO entity2Dto(Staffs entity) {
        StaffsDTO dto = new StaffsDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGender(entity.isGender());
        dto.setBirthday(entity.getBirthday());
        dto.setPhoto(entity.getPhoto());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setSalary(entity.getSalary());
        dto.setNotes(entity.getNotes());
        return dto;
    }

    public static Staffs dto2Entity(StaffsDTO dto) {
        Staffs entity = new Staffs();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setGender(dto.isGender());
        entity.setBirthday(dto.getBirthday());
        entity.setPhoto(dto.getPhoto());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setSalary(dto.getSalary());
        entity.setNotes(dto.getNotes());
        return entity;
    }

}
