package com.laptrinhjava5.dto;

import com.laptrinhjava5.entity.Departs;
import com.laptrinhjava5.model.DepartsDTO;

public class DepartsBeanUtil {

    public static DepartsDTO entity2Dto(Departs entity) {
        DepartsDTO dto = new DepartsDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static Departs dto2Entity(DepartsDTO dto) {
        Departs entity = new Departs();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
