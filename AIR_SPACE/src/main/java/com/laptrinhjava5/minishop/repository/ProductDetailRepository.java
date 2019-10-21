package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Product_Details;
import com.laptrinhjava5.minishop.entity.Products;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableAspectJAutoProxy
public interface ProductDetailRepository extends JpaRepository<Product_Details, Integer> {

    @Query(value = "SELECT * FROM Product_Details WHERE productID = :productID AND colorID = :colorID", nativeQuery = true)
    List<Product_Details> findByProductAndColor(@Param("productID") Integer productId, @Param("colorID") Integer colorId);

    List<Product_Details> findByProductId(Integer productId);

    Product_Details findByProductIdAndColorIdAndSizeId(Integer productId, Integer colorId, Integer sizeId);
}
