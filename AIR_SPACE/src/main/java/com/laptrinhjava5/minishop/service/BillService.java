package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.BillDao;
import com.laptrinhjava5.minishop.dao.BillDetailDao;
import com.laptrinhjava5.minishop.dao.UserDao;
import com.laptrinhjava5.minishop.entity.Bills;
import com.laptrinhjava5.minishop.entity.Users;
import com.laptrinhjava5.minishop.model.BillsVO;
import com.laptrinhjava5.minishop.model.MyCart;
import com.laptrinhjava5.minishop.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillDao billDao;

    @Autowired
    private BillDetailDao billDetailDao;

    @Autowired
    private UserDao userDao;

    public List<BillsVO> findAll() {
        List<Bills> billsList = billDao.findAll();
        List<BillsVO> result = new ArrayList<>();

        for (Bills item : billsList) {
            BillsVO vo = beanUtilCopy(item);
            result.add(vo);
        }
        return result;
    }

    public void saveBills(BillsVO billsVO, List<MyCart> myCartList) {
        int total = 0;

        for (MyCart myCart : myCartList) {
            total += myCart.getTotal();
        }
        billsVO.setTotal(total);

        Bills bill = billDao.save(billsVO);
        billDetailDao.save(bill, myCartList);
    }

    private BillsVO beanUtilCopy(Bills bill) {
        UserVO user = new UserVO(bill.getUser().getId(), bill.getUser().getName(), bill.getUser().getEmail());
        return new BillsVO(
                bill.getId(), bill.getAddress(), bill.getPhone(), bill.getNotes(), bill.getTotal(), bill.getStatus(), user
        );
    }

    private Bills beanUtilCopy(BillsVO vo) {
        Users user = userDao.findById(vo.getUser().getId());
        Bills entity = new Bills(
            vo.getAddress(), vo.getPhone(), vo.getNotes(), vo.getStatus(), vo.getTotal(), user
        );
        if (vo.getId() != null) {
            entity.setId(vo.getId());
        }
        return entity;
    }
}
