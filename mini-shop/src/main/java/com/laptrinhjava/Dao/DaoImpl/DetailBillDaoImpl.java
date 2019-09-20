package com.laptrinhjava.Dao.DaoImpl;

import com.laptrinhjava.Dao.AbstractDao.AbstractDao;
import com.laptrinhjava.Dao.Dao.DetailBillDao;
import com.laptrinhjava.Entity.Detail_Bill;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DetailBillDaoImpl extends AbstractDao<Integer, Detail_Bill> implements DetailBillDao {

}
