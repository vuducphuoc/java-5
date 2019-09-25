package com.laptrinhjava5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homeDefault(HttpSession httpSession) {
        return "web/home";
    }

    @GetMapping("about")
    public String aboutDefault() {
        return "web/about";
    }

    @GetMapping("admin/home")
    public String adminDefault() {
        return "admin/admin-home";
    }
}
