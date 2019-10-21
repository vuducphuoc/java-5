package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Bills;
import com.laptrinhjava5.minishop.entity.Categorys;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAspectJAutoProxy
public interface BillRepository extends JpaRepository<Bills, Integer> {
}
