package com.laptrinhjava5.minishop.controller.admin;

import com.google.gson.Gson;
import com.laptrinhjava5.minishop.model.*;
import com.laptrinhjava5.minishop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class Admin_ProductDetailController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private SizeService sizeService;


    @GetMapping("/san-pham-chi-tiet")
    public String getDefault(ModelMap modelMap) {
        List<CategorysVO> categorysVOList = categoryService.fillAll();
        List<ColorsVO> colorsVOList = colorService.findAll();
        List<SizesVO> sizesVOList = sizeService.findAll();

        String jsonCategory = new Gson().toJson(categorysVOList);
        String jsonColor = new Gson().toJson(colorsVOList);
        String jsonSize = new Gson().toJson(sizesVOList);

        modelMap.addAttribute("categoryList", jsonCategory);
        modelMap.addAttribute("colorList", jsonColor);
        modelMap.addAttribute("sizeList", jsonSize);
        return "adminProductDetailPage";
    }


    @PostMapping("/api/get-product-by-category")
    @ResponseBody
    public String getProductByCategory(@RequestParam Integer categoryId) {
        List<ProductsVO> productsVOList = productService.findByCategoryId(categoryId);

        String jsonProduct = new Gson().toJson(productsVOList);

        return jsonProduct;
    }

    @PostMapping("/api/get-detail-by-product")
    @ResponseBody
    public String getDetailByProduct(@RequestParam Integer productId) {
       List<Product_DetailsVO> productDetailsVOList = productDetailService.findByProductId(productId);

       String jsonProductDetail = new Gson().toJson(productDetailsVOList);
       return jsonProductDetail;
    }

    @PostMapping("/api/save-product-detail")
    @ResponseBody
    public String saveProductDetail(@ModelAttribute Product_DetailsVO productDetailsVO) {
        ResultValue resultValue = null;

        if (productDetailService.checkDetailExist(productDetailsVO.getProductId(), productDetailsVO.getColorId(), productDetailsVO.getSizeId())
                && productDetailsVO.getId() == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", "Chi tiết sản phẩm đã tồn tại !");
            resultValue = new ResultValue(null, error);
        } else  {
            Product_DetailsVO productDetails = productDetailService.save(productDetailsVO);
            resultValue = new ResultValue(productDetails, null);
        }

        String jsonProductDetail = new Gson().toJson(resultValue);
        return jsonProductDetail;
    }

    @PostMapping("/api/delete-product-detail")
    @ResponseBody
    public void deleteProductDetail(@RequestParam Integer id) {
        productDetailService.delete(id);
    }

}
