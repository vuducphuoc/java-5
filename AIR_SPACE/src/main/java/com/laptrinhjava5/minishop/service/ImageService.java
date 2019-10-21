package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.ColorDao;
import com.laptrinhjava5.minishop.dao.ImageDao;
import com.laptrinhjava5.minishop.dao.ProductDao;
import com.laptrinhjava5.minishop.entity.Colors;
import com.laptrinhjava5.minishop.entity.Images;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.model.ImagesVO;
import com.laptrinhjava5.minishop.repository.ColorRepository;
import com.laptrinhjava5.minishop.repository.ImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ColorDao colorDao;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ColorRepository colorRepository;

    public List<ImagesVO> findByProduct(Products product) {
        List<Images> imagesList = imageDao.findByProduct(product);
        List<ImagesVO> imagesVOList = new ArrayList<>();
        for (Images item : imagesList) {
            ImagesVO imagesVO = new ImagesVO(item.getId(), item.getName(), item.getColor().getId());
            imagesVOList.add(imagesVO);
        }
        return imagesVOList;
    }

    public List<ImagesVO> findByProductId(Integer id) {
        List<Images> imagesList = imageDao.findByProductId(id);
        List<ImagesVO> imagesVOList = beanUtilCopyToVO(imagesList);
        return imagesVOList;
    }

    public ImagesVO findFirstByProductId(Integer id) {
        Images images = imageDao.findFirstByProductId(id);
        ImagesVO imagesVO = new ImagesVO();
        BeanUtils.copyProperties(images, imagesVO);
        return imagesVO;
    }

    public List<ImagesVO> beanUtilCopyToVO(List<Images> imagesList) {
        List<ImagesVO> imagesVOList = new ArrayList<>();
        for (Images item : imagesList) {
            ImagesVO imagesVO = new ImagesVO(item.getId(), item.getName(), item.getColor().getId());
            imagesVOList.add(imagesVO);
        }
        return imagesVOList;
    }

    public void saveChangeImage(Integer[] images, Integer[] colors) {
        List<Images> imagesList = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            Images imageItem = imageRepository.getOne(images[i]);
            Colors colorItem = colorRepository.getOne(colors[i]);
            imageItem.setColor(colorItem);
            imagesList.add(imageItem);
        }
        imageRepository.saveAll(imagesList);
    }

    public ImagesVO saveImage(String name, Integer productId, Integer colorId) {
        Images image = imageDao.findByNameAndProductIdAndColorId(name, productId, colorId);

        if (image == null) {
            Products product = productDao.findById(productId);
            Colors color = colorDao.findById(colorId);
            image = new Images(name, color, product);
            image = imageDao.saveImage(image);
            ImagesVO result = new ImagesVO(image.getId(), image.getName(), image.getColor().getId());
            return result;
        } else {
            return null;
        }
    }

    public void deleteImage(Integer id) {
        imageDao.deleteImage(id);
    }
}
