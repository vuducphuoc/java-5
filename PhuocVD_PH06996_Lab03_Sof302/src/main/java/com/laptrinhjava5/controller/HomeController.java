package com.laptrinhjava5.controller;

import com.laptrinhjava5.model.Major;
import com.laptrinhjava5.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homeDefault() {
        return "home";
    }


    @GetMapping("bai01")
    public String getBai01(ModelMap modelMap) {
        Student student = new Student("Nguyễn Văn Tèo", 9.5, "WEB");
        modelMap.addAttribute("student", student);
        return "Bai01/Bai01";
    }

    @GetMapping("bai02")
    public String getBai02(ModelMap modelMap) {
        Student student = new Student("Nguyễn Văn Tèo", 9.5, "WEB");
        modelMap.addAttribute("student", student);
        return "Bai02/Bai02";
    }

    @GetMapping("bai03")
    public String getBai03(ModelMap modelMap) {
        Student student = new Student("Nguyễn Văn Tèo", 9.5, "WEB");
        modelMap.addAttribute("student", student);
        List<Major> majors = new ArrayList<>();
        majors.add(new Major("APP", "Ứng dụng phần mềm"));
        majors.add(new Major("WEB", "Thiết kế trang web"));
        modelMap.addAttribute("majors", majors);
        return "Bai03/Bai03";
    }
}
