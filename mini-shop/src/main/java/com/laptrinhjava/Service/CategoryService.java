package com.laptrinhjava.Service;

import com.laptrinhjava.Dao.DaoImpl.CategoryDaoImpl;
import com.laptrinhjava.Model.CategoryDTO;
import com.laptrinhjava.ModelUtils.CategoryBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDaoImpl categoryDao;

    public List<CategoryDTO> getAll() {
        return CategoryBeanUtil.listEntity2ListDto(categoryDao.findAll());
    }
}
