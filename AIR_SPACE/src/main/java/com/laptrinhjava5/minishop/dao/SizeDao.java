package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Sizes;
import com.laptrinhjava5.minishop.repository.SizeRepository;
import com.laptrinhjava5.minishop.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class SizeDao {

    @Autowired
    private SizeRepository sizeRepository;

    public List<Sizes> findAll() {
        return sizeRepository.findAll();
    }

    public Set<Sizes> findDistinctSizesByProduct(Integer productID) {
        return sizeRepository.findDistinctSizesByProduct(productID);
    }
    public Set<Sizes> findDistinctSizesByProductAndColor(Integer productID, Integer colorID) {
        return sizeRepository.findDistinctSizesByProductAndColor(productID, colorID);
    }

    public Sizes findById(Integer id) {
        return sizeRepository.getOne(id);
    }

}
