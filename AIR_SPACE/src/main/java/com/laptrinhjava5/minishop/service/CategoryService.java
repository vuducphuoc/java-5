package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.CategoryDao;
import com.laptrinhjava5.minishop.entity.Categorys;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.model.CategorysVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<CategorysVO> fillAll() {
        List<CategorysVO> categorysVOList = new ArrayList<>();
        List<Categorys> categorysList = categoryDao.fillAll();
        for (Categorys item : categorysList) {
            CategorysVO vo = new CategorysVO(item.getId(), item.getName());
            categorysVOList.add(vo);
        }
        return categorysVOList;
    }

    public CategorysVO findByProduct(Products product) {
        return null;
    }

    public CategorysVO getOne(Integer id) {
        Categorys categorys = categoryDao.getOne(id);
        CategorysVO result = new CategorysVO(categorys.getId(), categorys.getName());
        return result;
    }
}
