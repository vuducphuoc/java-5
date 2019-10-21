package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Images;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageDao {

    @Autowired
    private ImageRepository imageRepository;

    public List<Images> findByProduct(Products product) {
        return imageRepository.findByProduct(product);
    }

    public List<Images> findByProductId(Integer id) {
        return imageRepository.findByProductId(id);
    }

    public Images findByNameAndProductIdAndColorId(String name, Integer producId, Integer colorId) {
        return imageRepository.findByNameAndProductIdAndColorId(name, producId, colorId);
    }

    public Images findFirstByProductId(Integer id) {
        return imageRepository.findFirstByProductId(id);
    }

    public void saveChangeImage(List<Images> imagesList) {
        imageRepository.saveAll(imagesList);
    }

    public Images saveImage(Images image) {
        imageRepository.save(image);
        return image;
    }

    public void deleteImage(Integer id) {
        Images image = imageRepository.getOne(id);
        imageRepository.delete(image);
    }
}
