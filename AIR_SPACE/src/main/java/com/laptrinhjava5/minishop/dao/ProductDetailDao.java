package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Colors;
import com.laptrinhjava5.minishop.entity.Product_Details;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.entity.Sizes;
import com.laptrinhjava5.minishop.model.Product_DetailsVO;
import com.laptrinhjava5.minishop.repository.ColorRepository;
import com.laptrinhjava5.minishop.repository.ProductDetailRepository;
import com.laptrinhjava5.minishop.repository.ProductRepository;
import com.laptrinhjava5.minishop.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDetailDao{

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;

    public List<Product_Details> findByProductAndColor(Integer productId, Integer colorId) {
        return productDetailRepository.findByProductAndColor(productId, colorId);
    }

    public List<Product_Details> findAll() {
        return productDetailRepository.findAll();
    }

    public List<Product_Details> findByProductId(Integer productId) {
        return productDetailRepository.findByProductId(productId);
    }

    public Product_Details save(Product_DetailsVO productDetailsVO) {

        Colors color = colorRepository.getOne(productDetailsVO.getColorId());
        Sizes size = sizeRepository.getOne(productDetailsVO.getSizeId());
        Products product = productRepository.getOne(productDetailsVO.getProductId());

        Product_Details productDetail = new Product_Details(productDetailsVO.getQuantity(), product, color, size);
        if (productDetailsVO.getId() != null) {
            productDetail.setId(productDetailsVO.getId());
        }

        return productDetailRepository.save(productDetail);
    }

    public void delete(Integer id) {
        Product_Details product_detail = productDetailRepository.getOne(id);
        productDetailRepository.delete(product_detail);
    }

    public Product_Details findByProductIdAndColorIdAndSizeId(Integer productId, Integer colorId, Integer sizeId) {
        return productDetailRepository.findByProductIdAndColorIdAndSizeId(productId,colorId,sizeId);
    }
}
