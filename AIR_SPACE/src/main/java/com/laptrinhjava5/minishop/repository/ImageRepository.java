package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Categorys;
import com.laptrinhjava5.minishop.entity.Images;
import com.laptrinhjava5.minishop.entity.Products;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableAspectJAutoProxy
public interface ImageRepository extends JpaRepository<Images, Integer> {

    public Images findByNameAndProductIdAndColorId(String name, Integer productId, Integer colorId);

    public List<Images> findByProduct(Products product);

    public List<Images> findByProductId(Integer id);

    public Images findFirstByProductId(Integer id);

}
