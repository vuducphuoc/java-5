package com.laptrinhjava.Dao.DaoImpl;

import com.laptrinhjava.Dao.AbstractDao.AbstractDao;
import com.laptrinhjava.Dao.Dao.DetailProductDao;
import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Entity.Detail_Product;
import com.laptrinhjava.Entity.Product;
import com.laptrinhjava.Entity.Size;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DetailProductDaoImpl extends AbstractDao<Integer, Detail_Product> implements DetailProductDao {

    @Transactional
    public List<Detail_Product> getListByProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        List<Detail_Product> detailProductList = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder(" FROM ").append(getPersistenceClassName());
            sql.append(" WHERE product = :product");
            Query query = session.createQuery(sql.toString());
            query.setParameter("product", product);

            detailProductList = query.getResultList();
        } catch (Exception e) {
            throw e;
        }

        return detailProductList;
    }

    @Transactional
    public List<Size> getListSize(Product product) {
        Session session = sessionFactory.getCurrentSession();
        List<Size> sizeList = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("SELECT DISTINCT size FROM ").append(getPersistenceClassName());
            sql.append(" WHERE id_product = :product");
            Query query = session.createQuery(sql.toString());
            query.setParameter("product", product.getId());

            sizeList = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return sizeList;
    }

    @Transactional
    public List<Color> getListColor(Product product) {
        Session session = sessionFactory.getCurrentSession();
        List<Color> colorList = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("SELECT DISTINCT color FROM ").append(getPersistenceClassName());
            sql.append(" WHERE id_product = :product");
            Query query = session.createQuery(sql.toString());
            query.setParameter("product", product.getId());

            colorList = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return colorList;
    }

    @Transactional
    public Detail_Product getSingleResult(int idProduct, int idColor, int idSize) {
        Detail_Product  detailProduct = new Detail_Product();
        Session session = sessionFactory.getCurrentSession();
        try {
            StringBuilder sql = new StringBuilder(" FROM ").append(getPersistenceClassName());
            sql.append(" WHERE id_product = :product AND id_color = :color AND id_size = :size");

            Query query = session.createQuery(sql.toString());
            query.setParameter("product", idProduct);
            query.setParameter("color", idColor);
            query.setParameter("size", idSize);
            detailProduct = (Detail_Product) query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
        return detailProduct;
    }

}
