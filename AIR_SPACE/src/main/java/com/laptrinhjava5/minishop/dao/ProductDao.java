package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Images;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.repository.ImageRepository;
import com.laptrinhjava5.minishop.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    public List<Products> fillAll() {
        List<Products> productsList = productRepository.findAll();
        return productsList;
    }

    public Products findById(int id) {
        Products product = productRepository.getOne(id);
        List<Images> images = imageRepository.findByProduct(product);
        product.setImagesList(images);
        return product;
    }

    public List<Products> findByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Products> findByNameLike(String name) {
        List<Products> products = productRepository.findByNameContainingIgnoreCase(name);
        for (Products item : products) {
            List<Images> images = imageRepository.findByProduct(item);
            item.setImagesList(images);
        }
        return products;
    }

    public Products save(Products product) {
        Products result = productRepository.save(product);
        return result;
    }

    public Products update(Products product) {
        Products result = productRepository.getOne(product.getId());
        BeanUtils.copyProperties(product, result);

        productRepository.saveAndFlush(result);
        return result;
    }

    public void delete(Integer id) {
        Products product = productRepository.getOne(id);
        productRepository.delete(product);
    }

}
