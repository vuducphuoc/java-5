package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Bill_Details;
import com.laptrinhjava5.minishop.entity.Bills;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAspectJAutoProxy
public interface BillDetailRepository extends JpaRepository<Bill_Details, Integer> {
}
