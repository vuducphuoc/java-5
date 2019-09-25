package com.laptrinhjava5.dto;

import com.laptrinhjava5.entity.Records;
import com.laptrinhjava5.model.RecordsDTO;

public class RecordsBeanUtil {

    public static RecordsDTO entity2Dto(Records entity) {
        RecordsDTO dto = new RecordsDTO();
        dto.setId(entity.getId());
        dto.setType(entity.isType());
        dto.setReason(entity.getReason());
        dto.setDateCreate(entity.getDateCreate());
        return dto;
    }

    public static Records dto2Entity(RecordsDTO dto) {
        Records entity = new Records();
        entity.setId(dto.getId());
        entity.setType(dto.isType());
        entity.setReason(dto.getReason());
        entity.setDateCreate(dto.getDateCreate());
        return entity;
    }
}
