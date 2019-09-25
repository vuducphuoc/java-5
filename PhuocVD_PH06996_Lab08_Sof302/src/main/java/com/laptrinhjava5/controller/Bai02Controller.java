package com.laptrinhjava5.controller;

import com.laptrinhjava5.model.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bai02")
public class Bai02Controller {

    @GetMapping
    public String bai02Default() {
        return "web/bai02";
    }

//    @PostMapping
//    public String validate2(ModelMap modelMap, @Validated @ModelAttribute("student2") Student2 student2, BindingResult errors) {
//        if(errors.hasErrors()){
//            modelMap.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
//        }
//        else{
//            modelMap.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
//        }
//        return "web/bai02";
//    }
}
