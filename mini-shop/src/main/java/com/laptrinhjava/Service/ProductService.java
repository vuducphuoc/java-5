package com.laptrinhjava.Service;

import com.laptrinhjava.Dao.DaoImpl.DetailProductDaoImpl;
import com.laptrinhjava.Dao.DaoImpl.ProductDaoImpl;
import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Entity.Detail_Product;
import com.laptrinhjava.Entity.Product;
import com.laptrinhjava.Entity.Size;
import com.laptrinhjava.Model.ColorDTO;
import com.laptrinhjava.Model.DetailProductDTO;
import com.laptrinhjava.Model.ProductDTO;
import com.laptrinhjava.Model.SizeDTO;
import com.laptrinhjava.ModelUtils.ProductBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDaoImpl productDaoImpl;

    @Autowired
    DetailProductService detailProductService;

    @Autowired
    DetailProductDaoImpl detailProductDaoImpl;

    public ProductDTO getById(int id) {
        Product product = productDaoImpl.findById(id);
        List<DetailProductDTO> detailProductDTOList = detailProductService.getListDetailByProduct(product);
        List<ColorDTO> colorList = detailProductService.getListColor(product);
        List<SizeDTO> sizeList = detailProductService.getListSize(product);

        ProductDTO productDTO = ProductBeanUtil.entity2Dto(product);
        productDTO.setDetailProductList(detailProductDTOList);
        productDTO.setColorList(colorList);
        productDTO.setSizeList(sizeList);
        return productDTO;
    }

    public List<ProductDTO> findAll() {
        List<Product> productList = productDaoImpl.findAll();
        return ProductBeanUtil.listEntity2ListDto(productList);
    }

}
