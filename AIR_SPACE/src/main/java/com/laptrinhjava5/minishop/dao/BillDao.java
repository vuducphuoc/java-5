package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Bills;
import com.laptrinhjava5.minishop.entity.Users;
import com.laptrinhjava5.minishop.model.BillsVO;
import com.laptrinhjava5.minishop.repository.BillRepository;
import com.laptrinhjava5.minishop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillDao {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;

    public Bills save(BillsVO billsVO) {
        Users users = userRepository.findByEmail(billsVO.getUser().getEmail());
        Bills bill = new Bills(
                billsVO.getAddress(), billsVO.getPhone(), billsVO.getNotes(), 1 , billsVO.getTotal(), users
        );
        return billRepository.save(bill);
    }
}
