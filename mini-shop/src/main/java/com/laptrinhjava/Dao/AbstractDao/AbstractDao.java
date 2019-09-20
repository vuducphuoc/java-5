package com.laptrinhjava.Dao.AbstractDao;

import com.laptrinhjava.Dao.Utils.HibernateUtil;
import com.laptrinhjava.Web.common.constant.CoreConstant;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    private final Logger log = Logger.getLogger(this.getClass());
    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
    }

    @Autowired
    public SessionFactory sessionFactory;

    @Transactional
    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = sessionFactory.getCurrentSession();
        try {
            StringBuilder sql = new StringBuilder("FROM ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return list;
    }

    @Transactional
    public T update(T entity) {
        T result = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            Object object = session.merge(entity);
            result = (T) object;
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return result;
    }

    @Transactional
    public T save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(entity);
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return entity;
    }

    @Transactional
    public T findById(ID id) {
        T result = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            result = (T) session.get(persistenceClass, id);
            if (result == null) {
                throw new ObjectNotFoundException(" NOT FOUND " +id, null);
            }
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return result;
    }

    @Transactional
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, String whereClause) {
        List<T> list = new ArrayList<T>();
        Session session = sessionFactory.getCurrentSession();
        Object totalItem = 0;
        Object[] nameQuery = HibernateUtil.buildNameQuery(property);
        try {
            StringBuilder sql1 = new StringBuilder("from ");
            sql1.append(getPersistenceClassName()).append(" where 1=1 ").append(nameQuery[0]);
            if (sortExpression != null && sortDirection != null) {
                sql1.append(" order by ").append(sortExpression);
                sql1.append(" " +(sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            if (whereClause != null) {
                sql1.append(whereClause);
            }
            Query query1 = session.createQuery(sql1.toString());
            setParameterToQuery(nameQuery, query1);
            if (offset != null && offset >= 0) {
                query1.setFirstResult(offset);
            }
            if (limit != null && limit > 0) {
                query1.setMaxResults(limit);
            }
            list = query1.list();
            StringBuilder sql2 = new StringBuilder("select count(*) from ");
            sql2.append(getPersistenceClassName()).append(" where 1=1 ").append(nameQuery[0]);
            if (whereClause != null) {
                sql2.append(whereClause);
            }
            Query query2 = session.createQuery(sql2.toString());
            setParameterToQuery(nameQuery, query2);
            totalItem = query2.list().get(0);
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return new Object[]{totalItem, list};
    }

    private void setParameterToQuery(Object[] nameQuery, Query query) {
        if (nameQuery.length == 3) {
            String[] params = (String[]) nameQuery[1];
            Object[] values = (Object[]) nameQuery[2];
            for (int i2 = 0; i2 < params.length ; i2++) {
                query.setParameter(params[i2], values[i2]);
            }
        }
    }

    @Transactional
    public Integer delete(List<ID> ids) {
        Integer count = 0;
        Session session = sessionFactory.getCurrentSession();
        try {
            for (ID item: ids) {
                T t = (T) session.get(persistenceClass, item);
                session.delete(t);
                count++;
            }
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return count;
    }

    @Transactional
    public T findEqualUnique(String property, Object value) {
        Session session = sessionFactory.getCurrentSession();
        T result = null;
        try {
            String sql = " FROM "+getPersistenceClassName()+" Model WHERE Model."+property+"= :value";
            Query query = session.createQuery(sql.toString());
            query.setParameter("value", value);
            result = (T) query.uniqueResult();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return result;
    }

}
