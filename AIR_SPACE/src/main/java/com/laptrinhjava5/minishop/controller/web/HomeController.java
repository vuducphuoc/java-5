package com.laptrinhjava5.minishop.controller.web;

import com.laptrinhjava5.minishop.entity.Roles;
import com.laptrinhjava5.minishop.entity.Users;
import com.laptrinhjava5.minishop.model.ProductsVO;
import com.laptrinhjava5.minishop.model.UserVO;
import com.laptrinhjava5.minishop.repository.RoleRepository;
import com.laptrinhjava5.minishop.service.ProductService;
import com.laptrinhjava5.minishop.service.RoleService;
import com.laptrinhjava5.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("accountLogin")
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public String HomeDefault(ModelMap modelMap) {
        List<ProductsVO> vos = productService.findAll();
        modelMap.addAttribute("productListItem", vos);
        return "homePage";
    }

}
