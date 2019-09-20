package com.laptrinhjava.Dao.DaoImpl;

import com.laptrinhjava.Dao.AbstractDao.AbstractDao;
import com.laptrinhjava.Dao.Dao.CategoryDao;
import com.laptrinhjava.Entity.Category;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

}
