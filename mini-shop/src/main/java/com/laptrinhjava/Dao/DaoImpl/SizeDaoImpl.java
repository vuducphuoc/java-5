package com.laptrinhjava.Dao.DaoImpl;

import com.laptrinhjava.Dao.AbstractDao.AbstractDao;
import com.laptrinhjava.Dao.Dao.SizeDao;
import com.laptrinhjava.Entity.Size;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeDaoImpl extends AbstractDao<Integer, Size> implements SizeDao {

}
