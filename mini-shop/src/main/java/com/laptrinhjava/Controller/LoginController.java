package com.laptrinhjava.Controller;

import com.laptrinhjava.Model.AccountDTO;
import com.laptrinhjava.Service.AccountService;
import com.laptrinhjava.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("login")
@SessionAttributes("accountLogin")
public class LoginController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public String LoginDefault() {
        return "web/login";
    }

    @PostMapping
    public String LoginAction(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
        AccountDTO account = accountService.checkLogin(email, password);
        if (account != null) {
            modelMap.addAttribute("accountLogin", account);
            return "redirect:/";
        } else {
            modelMap.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác!");
            return "web/login";
        }
    }
}
