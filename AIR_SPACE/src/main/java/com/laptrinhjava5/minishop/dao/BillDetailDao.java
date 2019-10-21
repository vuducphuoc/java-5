package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Bill_Details;
import com.laptrinhjava5.minishop.entity.Bills;
import com.laptrinhjava5.minishop.entity.Product_Details;
import com.laptrinhjava5.minishop.model.MyCart;
import com.laptrinhjava5.minishop.repository.BillDetailRepository;
import com.laptrinhjava5.minishop.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillDetailDao {

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    public void save(Bills bill, List<MyCart> myCartList) {
        List<Bill_Details> billDetailsList = new ArrayList<>();

        for (MyCart item : myCartList) {
            Product_Details productDetail = productDetailRepository.findByProductIdAndColorIdAndSizeId(
                    item.getProduct().getId(), item.getColor().getId(), item.getSize().getId()
            );

            Bill_Details billDetail = new Bill_Details(item.getQuantity(), productDetail, bill);
            billDetailsList.add(billDetail);
        }
        billDetailRepository.saveAll(billDetailsList);
    }

}
