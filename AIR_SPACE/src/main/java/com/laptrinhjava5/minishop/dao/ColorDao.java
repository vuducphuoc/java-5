package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Colors;
import com.laptrinhjava5.minishop.entity.Product_Details;
import com.laptrinhjava5.minishop.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ColorDao {

    @Autowired
    private ColorRepository colorRepository;

    public List<Colors> findAll() {
        return colorRepository.findAll();
    }

    public Set<Colors> findDistinctColorsByProduct(Integer productID) {
        return colorRepository.findDistinctColorsByProduct(productID);
    }

    public Colors findById(Integer id) {
        return colorRepository.getOne(id);
    }
}
