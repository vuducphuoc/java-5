package com.laptrinhjava5.controller;

import com.laptrinhjava5.model.User;
import com.laptrinhjava5.utils.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    User user;

    @Autowired
    ServletContext context;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("bai01")
    public String bai01(ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "bai01";
    }

    @GetMapping("bai02")
    public String bai02(ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "bai02";
    }

    @PostMapping("apply")
    public String apply(ModelMap modelMap,
                        @RequestParam("fullname") String fullname,
                        @RequestParam("cv") MultipartFile cv,
                        @RequestParam("photo") MultipartFile photo) {

        if (photo.isEmpty() || cv.isEmpty()) {
            modelMap.addAttribute("message", "Vui lòng chọn file !");
        } else {
            try {
                String photoPath = context.getRealPath("/resources/" + photo.getOriginalFilename());
                File file = new File(photoPath);
                photo.transferTo(file);

                String cvPath = context.getRealPath("/resources/" + cv.getOriginalFilename())  ;
                cv.transferTo(new File(cvPath));

                modelMap.addAttribute("photo_name", photo.getOriginalFilename());
                modelMap.addAttribute("cv_name", cv.getOriginalFilename());
                modelMap.addAttribute("cv_type", cv.getContentType());
                modelMap.addAttribute("cv_size", cv.getSize());
            } catch (Exception e) {
                modelMap.addAttribute("message", "Lỗi lưu file !");
            }
        }
        return "bai02";
    }

    @GetMapping("bai03")
    public String bai03() {
        return "bai03";
    }

    @Autowired
    Mailer mailer;

    @PostMapping("send")
    public String send(ModelMap modelMap,
                       @RequestParam("from") String from,
                       @RequestParam("to") String to,
                       @RequestParam("subject") String subject,
                       @RequestParam("body") String body) {

        try {
            mailer.send(from, to, subject , body);
            modelMap.addAttribute("alertType", "success");
            modelMap.addAttribute("alertMessage", "Gửi email thành công!");
        } catch (Exception e) {
            modelMap.addAttribute("alertType", "warning");
            modelMap.addAttribute("alertMessage", "Gửi email thất bại!");
        }

        return "bai03";
    }
}
