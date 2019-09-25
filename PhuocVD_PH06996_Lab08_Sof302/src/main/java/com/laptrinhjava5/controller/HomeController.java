package com.laptrinhjava5.controller;

import com.laptrinhjava5.model.Student1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homeDefault(ModelMap modelMap) {
        return "web/home";
    }
}
