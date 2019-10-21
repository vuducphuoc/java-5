package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Categorys;
import com.laptrinhjava5.minishop.entity.Products;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableAspectJAutoProxy
public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findByNameContainingIgnoreCase(String name);

    Products findAllById(int id);

    List<Products> findByCategoryId(Integer categoryId);
}
