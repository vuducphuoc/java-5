package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.BillDao;
import com.laptrinhjava5.minishop.dao.BillDetailDao;
import com.laptrinhjava5.minishop.entity.Bills;
import com.laptrinhjava5.minishop.model.BillsVO;
import com.laptrinhjava5.minishop.model.MyCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillDao billDao;

    @Autowired
    private BillDetailDao billDetailDao;

    public void saveBills(BillsVO billsVO, List<MyCart> myCartList) {
        int total = 0;

        for (MyCart myCart : myCartList) {
            total += myCart.getTotal();
        }
        billsVO.setTotal(total);

        Bills bill = billDao.save(billsVO);
        billDetailDao.save(bill, myCartList);
    }
}
