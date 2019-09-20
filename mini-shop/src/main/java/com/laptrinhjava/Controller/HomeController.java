package com.laptrinhjava.Controller;

import com.laptrinhjava.Model.BillDTO;
import com.laptrinhjava.Model.ProductDTO;
import com.laptrinhjava.Service.BillService;
import com.laptrinhjava.Service.ProductService;
import com.laptrinhjava.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("accountLogin")
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    BillService billService;

    @GetMapping
    public String HomeDefault(ModelMap modelMap) {
        List<ProductDTO> productDTOList = productService.findAll();
        modelMap.addAttribute("listProducts", productDTOList);
        return "web/home";
    }

}
