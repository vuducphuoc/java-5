package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Categorys;
import com.laptrinhjava5.minishop.entity.Sizes;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@EnableAspectJAutoProxy
public interface SizeRepository extends JpaRepository<Sizes, Integer> {

    @Query(value = "SELECT DISTINCT * FROM Sizes INNER JOIN Product_Details PD on Sizes.id = PD.sizeID" +
            " WHERE PD.productID = :productID", nativeQuery = true)
    Set<Sizes> findDistinctSizesByProduct(@Param("productID") Integer productID);

    @Query(value = "SELECT DISTINCT * FROM Sizes INNER JOIN Product_Details PD on Sizes.id = PD.sizeID" +
            " WHERE PD.productID = :productID AND PD.colorID = :colorID", nativeQuery = true)
    Set<Sizes> findDistinctSizesByProductAndColor(@Param("productID") Integer productID, @Param("colorID") Integer coloriD);
}
