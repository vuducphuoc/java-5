package com.laptrinhjava.Service;

import com.laptrinhjava.Dao.AbstractDao.GenericDao;
import com.laptrinhjava.Dao.DaoImpl.ColorDaoImpl;
import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Model.ColorDTO;
import com.laptrinhjava.ModelUtils.ColorBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ColorService{
    @Autowired
    ColorDaoImpl colorDaoImpl;

    public ColorDTO getById(int id) {
        Color color = colorDaoImpl.findById(id);
        return ColorBeanUtil.entity2Dto(color);
    }
}
