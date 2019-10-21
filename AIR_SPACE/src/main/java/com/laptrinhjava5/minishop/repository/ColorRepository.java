package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Colors;
import com.laptrinhjava5.minishop.entity.Product_Details;
import com.laptrinhjava5.minishop.entity.Products;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@EnableAspectJAutoProxy
public interface ColorRepository extends JpaRepository<Colors, Integer> {

    @Query(value = "SELECT DISTINCT * FROM Colors INNER JOIN Product_Details PD on Colors.id = PD.colorID" +
            " WHERE PD.productID = :productID", nativeQuery = true)
    Set<Colors> findDistinctColorsByProduct(@Param("productID") Integer productID);
}
