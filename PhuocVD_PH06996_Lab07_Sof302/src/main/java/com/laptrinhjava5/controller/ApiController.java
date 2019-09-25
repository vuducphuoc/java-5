package com.laptrinhjava5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/language")
    @ResponseBody
    public String changeLanguage(HttpSession httpSession, @RequestParam String language) {
        String lang = (String) httpSession.getAttribute("language");
        lang = language;
        httpSession.setAttribute("language", lang);
        return lang;
    }
}
