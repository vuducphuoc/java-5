package com.laptrinhjava5.minishop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access-denied")
public class AccessDeniedController {

    @GetMapping
    public String deniedDefault() {
        return "Xin lỗi! Bạn không có quyền truy cập vào trang web này.";
    }
}
