package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.ColorDao;
import com.laptrinhjava5.minishop.entity.Colors;
import com.laptrinhjava5.minishop.entity.Product_Details;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.model.ColorsVO;
import com.laptrinhjava5.minishop.model.Product_DetailsVO;
import com.laptrinhjava5.minishop.model.ProductsVO;
import com.laptrinhjava5.minishop.repository.ColorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class ColorService {

    @Autowired
    private ColorDao colorDao;

    public List<ColorsVO> findDistinctColorsByProduct(Integer productID) {
        Set<Colors> colorsList = colorDao.findDistinctColorsByProduct(productID);
        List<ColorsVO> colorsVOList = beanUtilsCopy(colorsList);
        return colorsVOList;
    }

    public ColorsVO findById(Integer id) {
        Colors entity = colorDao.findById(id);
        ColorsVO vo = new ColorsVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    public List<ColorsVO> findAll () {
        List<Colors> colorsList = colorDao.findAll();
        List<ColorsVO> result = beanUtilsCopy(colorsList);
        return result;
    }

    public List<ColorsVO> beanUtilsCopy(Collection<Colors> colorsList) {
        List<ColorsVO> colorsVOList = new ArrayList<>();
        for (Colors item : colorsList) {
            ColorsVO vo  = new ColorsVO();
            BeanUtils.copyProperties(item, vo);
            colorsVOList.add(vo);
        }
        return colorsVOList;
    }
}
