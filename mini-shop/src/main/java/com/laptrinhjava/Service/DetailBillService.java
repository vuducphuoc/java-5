package com.laptrinhjava.Service;

import com.laptrinhjava.Dao.DaoImpl.DetailBillDaoImpl;
import com.laptrinhjava.Entity.Detail_Bill;
import com.laptrinhjava.Model.BillDTO;
import com.laptrinhjava.Model.DetailBillDTO;
import com.laptrinhjava.ModelUtils.DetailBillBeanUtil;
import com.laptrinhjava.ModelUtils.DetailProductBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailBillService {
    @Autowired
    DetailBillDaoImpl detailBillDao;

    public void save(DetailBillDTO dto) {
        Detail_Bill entity = DetailBillBeanUtil.dto2Entity(dto);
        entity = detailBillDao.save(entity);
    }
}
