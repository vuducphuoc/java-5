package com.laptrinhjava5.minishop.controller.web;

import com.laptrinhjava5.minishop.model.UserVO;
import com.laptrinhjava5.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String AccountDefault() {
        return "accountPage";
    }

    @GetMapping("/my-cart")
    public String myCart() {
        return "accountPage";
    }

    @GetMapping("/change-password")
    public String changePassword() {
        return "changePasswordPage";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String oldPassword, @RequestParam String newPassword, HttpSession httpSession, ModelMap modelMap) {
        UserVO userLogin = (UserVO) httpSession.getAttribute("userLogin");

        boolean check = userService.checkChangePassword(userLogin.getEmail(), oldPassword);
        if (!check) {
            modelMap.addAttribute("alertType", "alert-warning");
            modelMap.addAttribute("alertMessage", "Mật khẩu cũ không chính xác!");
        } else {
            userService.changePassword(userLogin.getEmail(), oldPassword, newPassword);
            modelMap.addAttribute("alertType", "alert-success");
            modelMap.addAttribute("alertMessage", "Thay đổi mật khẩu thành công!");
        }

        return "changePasswordPage";
    }

}
