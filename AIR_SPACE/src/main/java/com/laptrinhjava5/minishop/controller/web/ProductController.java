package com.laptrinhjava5.minishop.controller.web;

import com.laptrinhjava5.minishop.model.ColorsVO;
import com.laptrinhjava5.minishop.model.ProductsVO;
import com.laptrinhjava5.minishop.model.SizesVO;
import com.laptrinhjava5.minishop.service.ColorService;
import com.laptrinhjava5.minishop.service.ProductDetailService;
import com.laptrinhjava5.minishop.service.ProductService;
import com.laptrinhjava5.minishop.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;

    @Autowired
    ColorService colorService;

    @Autowired
    SizeService sizeService;

    @GetMapping("/{id}")
    public String ProductDefault(@PathVariable int id, ModelMap modelMap) {
        ProductsVO productsVO = productService.findById(id);
        List<ColorsVO> colorsVOList = colorService.findDistinctColorsByProduct(productsVO.getId());
        List<SizesVO> sizesVOList = sizeService.findDistinctSizesByProduct(productsVO.getId());
        productsVO.setColorsList(colorsVOList);
        productsVO.setSizesList(sizesVOList);
        modelMap.addAttribute("productItem", productsVO);
        return "productDetailPage";
    }

}
