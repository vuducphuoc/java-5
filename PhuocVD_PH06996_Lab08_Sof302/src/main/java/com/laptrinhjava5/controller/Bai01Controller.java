package com.laptrinhjava5.controller;

import com.laptrinhjava5.model.Major;
import com.laptrinhjava5.model.Student1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bai01")
public class Bai01Controller {

    @GetMapping
    public String bai01Default(ModelMap modelMap) {
        Student1 student = new Student1("Nguyễn Văn Tèo", 9.5, "WEB");
        modelMap.addAttribute("student", student);
        List<Major> majors = new ArrayList<>();
        majors.add(new Major("APP", "Ứng dụng phần mềm"));
        majors.add(new Major("WEB", "Thiết kế trang web"));
        modelMap.addAttribute("majors", majors);
        return "web/bai01";
    }

//    @PostMapping
//    public String validate1(ModelMap modelMap, @ModelAttribute("student") Student1 student1, BindingResult errors) {
//        if (student1.getName().trim().length() == 0) {
//            errors.rejectValue("name", "student", "Vui lòng nhập họ tên !");
//        }
//        if (student1.getMark() == null) {
//            errors.rejectValue("mark", "student", "Vui lòng nhập điểm !");
//        } else if (student1.getMark() < 0 || student1.getMark() > 10) {
//            errors.rejectValue("mark", "student", "Điểm không hợp lệ  !");
//        }
//        if (student1.getMajor() == null) {
//            errors.rejectValue("major", "student", "Vui lòng chọn một chuyên ngành !");
//        }
//
//        if(errors.hasErrors()){
//            modelMap.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
//        }
//        else{
//            modelMap.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
//        }
//        return "web/bai01";
//    }
}
