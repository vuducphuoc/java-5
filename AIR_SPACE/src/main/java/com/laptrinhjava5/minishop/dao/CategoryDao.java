package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Categorys;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDao {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Categorys> fillAll() {
        return categoryRepository.findAll();
    }

    public Categorys findByProduct(Products product) {
        return null;
    }

    public Categorys getOne(Integer id) {
        return categoryRepository.getOne(id);
    }
}
