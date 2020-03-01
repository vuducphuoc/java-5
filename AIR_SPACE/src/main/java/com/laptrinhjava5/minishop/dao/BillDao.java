package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Bills;
import com.laptrinhjava5.minishop.entity.Users;
import com.laptrinhjava5.minishop.model.BillsVO;
import com.laptrinhjava5.minishop.repository.BillRepository;
import com.laptrinhjava5.minishop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillDao {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;

    public Bills save(BillsVO billsVO) {
        Users users = userRepository.findByEmail(billsVO.getUser().getEmail());
        Bills bill = new Bills(null,
                billsVO.getAddress(), billsVO.getPhone(), billsVO.getNotes(), 1 , billsVO.getTotal(), users
        );
        return billRepository.save(bill);
    }

    public List<Bills> findAll() {
        return billRepository.findAll();
    }
}
