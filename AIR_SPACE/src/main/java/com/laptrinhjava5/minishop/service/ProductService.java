package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.CategoryDao;
import com.laptrinhjava5.minishop.dao.ImageDao;
import com.laptrinhjava5.minishop.dao.ProductDao;
import com.laptrinhjava5.minishop.entity.Categorys;
import com.laptrinhjava5.minishop.entity.Images;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.model.CategorysVO;
import com.laptrinhjava5.minishop.model.ImagesVO;
import com.laptrinhjava5.minishop.model.ProductsVO;
import com.laptrinhjava5.minishop.repository.ImageRepository;
import com.laptrinhjava5.minishop.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CategoryDao categoryDao;

    public List<ProductsVO> findAll() {
        List<ProductsVO> vos = new ArrayList<>();
        List<Products> entities = productDao.fillAll();

        for(Products item : entities) {
            List<ImagesVO> imagesVOList = imageService.findByProduct(item);
            CategorysVO categorysVO = new CategorysVO(item.getCategory().getId(), item.getCategory().getName());

            ProductsVO vo = new ProductsVO(
                item.getId(), item.getName(), item.getPrice(), item.getDescribes(), categorysVO, imagesVOList
            );
            vos.add(vo);
        }
        return vos;
    }

    public ProductsVO findById(int id) {
        Products entity = productDao.findById(id);
        ProductsVO productsVO = new ProductsVO();
        BeanUtils.copyProperties(entity, productsVO);
        return productsVO;
    }

    public List<ProductsVO> findByCategoryId(Integer cateforyId) {
        List<Products> productsList = productDao.findByCategoryId(cateforyId);
        List<ProductsVO> result = new ArrayList<>();

        for (Products item : productsList) {
            ProductsVO vo = new ProductsVO(item.getId(), item.getName(), item.getPrice(), item.getDescribes());
            result.add(vo);
        }

        return result;
    }

    public List<ProductsVO> findByNameLike(String name) {
        List<Products> productsList = productDao.findByNameLike(name);
        List<ProductsVO> productsVOList = new ArrayList<>();
        for (Products item : productsList) {
            ProductsVO vo = new ProductsVO();
            BeanUtils.copyProperties(item, vo);
            productsVOList.add(vo);
        }
        return productsVOList;
    }

    public ProductsVO saveOrUpdate(ProductsVO productsVO) {
        ProductsVO result = new ProductsVO();

        Categorys category = categoryDao.getOne(productsVO.getCategoryId());
        Products product = new Products(productsVO.getName(), productsVO.getPrice(), productsVO.getDescribes(), category);

        if (productsVO.getId() == null) {
            product = productDao.save(product);
        } else {
            product.setId(productsVO.getId());
            product = productDao.update(product);
        }

        BeanUtils.copyProperties(product, result);
        result.setCategory(new CategorysVO(category.getId(), category.getName()));
        result.setImagesList(imageService.findByProduct(product));
        return result;
    }

    public void delete(Integer id) {
        productDao.delete(id);
    }
}
