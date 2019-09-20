package com.laptrinhjava.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping
    public String AccountDefault() {
        return "web/account";
    }

    @GetMapping("/address")
    public String AccountAddress() {
        return "web/account";
    }

    @GetMapping("/logout")
    public String AccountLogout(HttpSession httpSession) {
        httpSession.removeAttribute("accountLogin");
        return "redirect:/login";
    }

}
