package com.laptrinhjava5.controller;

import com.laptrinhjava5.model.Product;
import com.laptrinhjava5.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    ServletContext application;

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("bai01")
    public String bai01(HttpServletRequest request, HttpSession session) {
        application.setAttribute("name", "Phạm Minh Tuấn");
        application.setAttribute("level", 2);

        session.setAttribute("name", "Nguyễn Thị Kiều Oanh");
        session.setAttribute("level", 4);

        request.setAttribute("name", "Lê Phạm Tuấn Kiệt");
        request.setAttribute("level", 3);

        session.setAttribute("salary", 1000);
        request.setAttribute("photo", "images/poly-sv.png");
        return "bai01";
    }

    @GetMapping("bai02")
    public String bai02(ModelMap modelMap) {
        Student sv1 = new Student("Phạm Minh Tuấn", 5.5, "Ứng dụng phần mềm");
        Student sv2 = new Student("Nguyễn Thị Kiều Oanh", 9.5, "Thiết kế trang web");
        Student sv3 = new Student("Lê Phạm Tuấn Kiệt", 3.5, "Thiết kế trang web");

        List<Student> list = new ArrayList<>();
        list.add(sv2);
        list.add(sv3);

        Map<String, Student> map = new HashMap<>();
        map.put("OanhNTK", sv2);
        map.put("KietLPT", sv3);

        modelMap.addAttribute("bean", sv1);
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("map", map);

        return "bai02";
    }

    @GetMapping("bai04")
    public String bai04(ModelMap modelMap) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Nokia Star", 1000.0, 0.05));
        list.add(new Product("iPhone 9", 1500.0, 0.1));
        list.add(new Product("Samsung Galaxy N10", 750.0, 0.15));
        list.add(new Product("Sony Experia", 500.0, 0.0));
        modelMap.addAttribute("prods", list);
        return "bai04";
    }
}
