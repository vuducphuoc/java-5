package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.ProductDetailDao;
import com.laptrinhjava5.minishop.entity.Colors;
import com.laptrinhjava5.minishop.entity.Product_Details;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.model.ColorsVO;
import com.laptrinhjava5.minishop.model.Product_DetailsVO;
import com.laptrinhjava5.minishop.model.ProductsVO;
import com.laptrinhjava5.minishop.model.SizesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailDao productDetailDao;

    public List<Product_DetailsVO> findByProductAndColor(Integer productId, Integer colorId) {
        List<Product_Details> productDetailsList = productDetailDao.findByProductAndColor(productId, colorId);
        List<Product_DetailsVO> productDetailsVOList = new ArrayList<>();
        for (Product_Details item : productDetailsList) {
            Product_DetailsVO vo = new Product_DetailsVO();
            SizesVO sizesVO = new SizesVO();
            BeanUtils.copyProperties(item, vo);
            BeanUtils.copyProperties(item.getSize(), sizesVO);

            vo.setSize(sizesVO);
            productDetailsVOList.add(vo);
        }
        return productDetailsVOList;
    }

    public List<Product_DetailsVO> findAll() {
        List<Product_Details> productDetailsList = productDetailDao.findAll();
        List<Product_DetailsVO> productDetailsVOList = new ArrayList<>();
        for (Product_Details item : productDetailsList) {
            Product_DetailsVO vo = new Product_DetailsVO();
            BeanUtils.copyProperties(item, vo);
            productDetailsVOList.add(vo);
        }
        return productDetailsVOList;
    }

    public List<Product_DetailsVO> findByProductId(Integer productId) {
        List<Product_Details> productDetailsList = productDetailDao.findByProductId(productId);
        List<Product_DetailsVO> result = new ArrayList<>();

        for (Product_Details item : productDetailsList) {
            ProductsVO productsVO = new ProductsVO(item.getProduct().getId(), item.getProduct().getName());
            ColorsVO colorsVO = new ColorsVO(item.getColor().getId(), item.getColor().getName());
            SizesVO sizesVO = new SizesVO(item.getSize().getId(), item.getSize().getName());

            Product_DetailsVO vo = new Product_DetailsVO(item.getId(), item.getQuantity(), productsVO, colorsVO, sizesVO );
            result.add(vo);
        }
        return result;
    }

    public Product_DetailsVO save(Product_DetailsVO productDetailsVO) {
        Product_Details productDetail = productDetailDao.save(productDetailsVO);
        return beanUtilCopy(productDetail);
    }

    public void delete(Integer id) {
        productDetailDao.delete(id);
    }

    public boolean checkDetailExist(Integer productId, Integer colorId, Integer sizeId) {
        Product_Details productDetail = productDetailDao.findByProductIdAndColorIdAndSizeId(productId,colorId,sizeId);
        if (productDetail == null) {
            return false;
        } else {
            return true;
        }
    }


    public Product_DetailsVO beanUtilCopy(Product_Details entity) {
        ProductsVO productsVO = new ProductsVO(entity.getProduct().getId(), entity.getProduct().getName());
        SizesVO sizesVO = new SizesVO(entity.getSize().getId(), entity.getSize().getName());
        ColorsVO colorsVO = new ColorsVO(entity.getColor().getId(), entity.getColor().getName());
        return new Product_DetailsVO(entity.getId(), entity.getQuantity(), productsVO, colorsVO, sizesVO);
    }
}
