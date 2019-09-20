package com.laptrinhjava.Service;

import com.laptrinhjava.Dao.AbstractDao.GenericDao;
import com.laptrinhjava.Dao.DaoImpl.SizeDaoImpl;
import com.laptrinhjava.Entity.Size;
import com.laptrinhjava.Model.SizeDTO;
import com.laptrinhjava.ModelUtils.SizeBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class SizeService  {

    @Autowired
    SizeDaoImpl sizeDaoImpl;

    public SizeDTO getById(int id) {
        Size size = sizeDaoImpl.findById(id);
        return SizeBeanUtil.entity2Dto(size);
    }
}
