package com.laptrinhjava.Controller;

import com.laptrinhjava.Model.ProductDTO;
import com.laptrinhjava.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public String ProductDefault(@PathVariable int id, ModelMap modelMap) {
        ProductDTO productDTO = productService.getById(id);
        modelMap.addAttribute("productItem", productDTO);
        return "product/detail-product";
    }



}
