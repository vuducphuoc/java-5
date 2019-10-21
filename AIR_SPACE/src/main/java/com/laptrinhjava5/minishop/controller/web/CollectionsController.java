package com.laptrinhjava5.minishop.controller.web;

import com.laptrinhjava5.minishop.model.ProductsVO;
import com.laptrinhjava5.minishop.service.CategoryService;
import com.laptrinhjava5.minishop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/collections")
public class CollectionsController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping
    public String search(@RequestParam(required = false) String txt, ModelMap modelMap) {
        List<ProductsVO> productsVOList = productService.findByNameLike(txt);
        modelMap.addAttribute("productListItem", productsVOList);
        return "collectionsPage";
    }

    @GetMapping("/top-san-pham-ban-chay")
    public String getTopProduct(ModelMap modelMap){
        List<ProductsVO> productDTOList = productService.findAll();
        modelMap.addAttribute("productListItem", productDTOList);
        return "collectionsPage";
    }

    @GetMapping("/hang-moi-ve")
    public String getNewProduct(ModelMap modelMap){
        List<ProductsVO> productDTOList = productService.findAll();
        modelMap.addAttribute("productListItem", productDTOList);
        return "collectionsPage";
    }

    @GetMapping("/{value}")
    public String getCollections(@PathVariable String value, ModelMap modelMap){
        return "product/collections";
    }

}
