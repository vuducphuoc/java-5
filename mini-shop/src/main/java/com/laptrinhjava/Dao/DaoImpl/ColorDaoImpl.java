package com.laptrinhjava.Dao.DaoImpl;

import com.laptrinhjava.Dao.AbstractDao.AbstractDao;
import com.laptrinhjava.Dao.Dao.ColorDao;
import com.laptrinhjava.Entity.Color;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ColorDaoImpl extends AbstractDao<Integer, Color> implements ColorDao {

}
