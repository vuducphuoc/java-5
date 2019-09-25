package com.laptrinhjava5.daoImpl;


import com.laptrinhjava5.dao.AbstractDao;
import com.laptrinhjava5.dao.UsersDao;
import com.laptrinhjava5.entity.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsersDaoImpl extends AbstractDao<Integer, Users> implements UsersDao {
}
