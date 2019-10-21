package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.SizeDao;
import com.laptrinhjava5.minishop.entity.Sizes;
import com.laptrinhjava5.minishop.model.SizesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SizeService {

    @Autowired
    private SizeDao sizeDao;

    public List<SizesVO> findAll() {
        List<Sizes> sizesList = sizeDao.findAll();
        List<SizesVO> result = new ArrayList<>();

        for (Sizes item : sizesList) {
            SizesVO sizesVO = new SizesVO(item.getId(), item.getName());
            result.add(sizesVO);
        }
        return result;
    }

    public List<SizesVO> findDistinctSizesByProduct(Integer productID) {
        Set<Sizes> sizesSet = sizeDao.findDistinctSizesByProduct(productID);
        List<SizesVO> sizesVOList = new ArrayList<>();
        for (Sizes item : sizesSet) {
            SizesVO vo  = new SizesVO();
            BeanUtils.copyProperties(item, vo);
            sizesVOList.add(vo);
        }
        return sizesVOList;
    }

    public List<SizesVO> findDistinctSizesByProductAndColor(Integer productID, Integer colorID) {
        Set<Sizes> sizesSet = sizeDao.findDistinctSizesByProductAndColor(productID, colorID);
        List<SizesVO> sizesVOList = new ArrayList<>();
        for (Sizes item : sizesSet) {
            SizesVO vo  = new SizesVO();
            BeanUtils.copyProperties(item, vo);
            sizesVOList.add(vo);
        }
        return sizesVOList;
    }

    public SizesVO findById(Integer id) {
        Sizes sizes = sizeDao.findById(id);
        SizesVO sizesVO = new SizesVO();
        BeanUtils.copyProperties(sizes, sizesVO);
        return sizesVO;
    }
}
