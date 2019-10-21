package com.laptrinhjava5.minishop.controller.web;

import com.laptrinhjava5.minishop.model.UserVO;
import com.laptrinhjava5.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping
    public String LoginDefault(@RequestParam(required = false) String error, HttpSession httpSession) {
        UserVO userLogin = (UserVO) httpSession.getAttribute("userLogin");
        if (userLogin == null) {
            return "loginPage";
        } else {
            return "redirect:account";
        }
    }

}
