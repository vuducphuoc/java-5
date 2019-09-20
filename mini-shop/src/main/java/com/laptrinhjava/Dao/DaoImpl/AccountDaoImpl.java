package com.laptrinhjava.Dao.DaoImpl;

import com.laptrinhjava.Dao.AbstractDao.AbstractDao;
import com.laptrinhjava.Dao.Dao.UserDao;
import com.laptrinhjava.Entity.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountDaoImpl extends AbstractDao<Integer, Account> implements UserDao {

    @Transactional
    public Account checkLogin(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Account account = new Account();
        try {
            StringBuilder sql = new StringBuilder(" FROM ").append(getPersistenceClassName());
            sql.append(" WHERE email = :email");
            sql.append(" AND password = :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("email", email);
            query.setParameter("password", password);
            account = (Account) query.uniqueResult();

        } catch (HibernateException e) {
            throw e;
        }
        return account;
    }

    @Transactional
    public boolean checkEmailExist(String email) {
        boolean check = false;
        Session session = sessionFactory.getCurrentSession();
        try {
            StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ").append(getPersistenceClassName());
            sql.append(" WHERE email = :email");
            Query query = session.createQuery(sql.toString());
            query.setParameter("email", email);

            long count = (long) query.getSingleResult();
            if (count > 0) {
                check = true;
            }
        } catch (HibernateException e) {
            throw e;
        }

        return check;
    }

}
