package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Categorys;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAspectJAutoProxy
public interface CategoryRepository extends JpaRepository<Categorys, Integer> {

}
