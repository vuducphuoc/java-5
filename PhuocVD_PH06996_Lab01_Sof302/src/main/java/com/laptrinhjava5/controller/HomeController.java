package com.laptrinhjava5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homeDefault() {
        return "home";
    }

    @GetMapping("student")
    public String studentForm() {
        return "student-form";
    }

    @PostMapping("success")
    public String studentSuccess(@RequestParam("name") String name, @RequestParam int mark, @RequestParam String major, ModelMap modelMap) {
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("mark", mark);
        modelMap.addAttribute("major", major.equalsIgnoreCase("APP") ? "Ứng dụng phần mềm" : "Thiết kế trang web");
        return "student-success";
    }

}
