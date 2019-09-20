package com.laptrinhjava.Service;

import com.laptrinhjava.Dao.DaoImpl.BillDaoImpl;
import com.laptrinhjava.Entity.Bill;
import com.laptrinhjava.Model.BillDTO;
import com.laptrinhjava.ModelUtils.BillBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BillService {
    @Autowired
    BillDaoImpl billDaoImpl;

    public List<BillDTO> findAll() {
        List<Bill> bills = billDaoImpl.findAll();
        List<BillDTO> billDTOList = new ArrayList<>();

        for (Bill item : bills) {
            billDTOList.add(BillBeanUtil.entity2Dto(item));
        }
        return billDTOList;
    }

    public BillDTO save(BillDTO billDTO) {
        Bill bill = BillBeanUtil.dto2Entity(billDTO);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        bill.setDate_created(simpleDateFormat.format(new Date()));
        bill = billDaoImpl.save(bill);
        return BillBeanUtil.entity2Dto(bill);
    }

}
