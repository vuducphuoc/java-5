package com.laptrinhjava.Dao.DaoImpl;

import com.laptrinhjava.Dao.AbstractDao.AbstractDao;
import com.laptrinhjava.Dao.Dao.BillDao;
import com.laptrinhjava.Entity.Bill;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BillDaoImpl extends AbstractDao<Integer, Bill> implements BillDao {

}
