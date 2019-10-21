package com.laptrinhjava5.minishop.controller.web;


import com.laptrinhjava5.minishop.model.UserVO;
import com.laptrinhjava5.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getDefault(ModelMap modelMap) {
        return "registerPage";
    }

    @PostMapping
    public String register(@ModelAttribute UserVO model, ModelMap modelMap) {
        boolean check = userService.checkEmailExist(model.getEmail());
        if (check) {
            modelMap.addAttribute("alertType", "alert-warning");
            modelMap.addAttribute("alertMessage", "Email đã tồn tại!");
        } else {
            userService.saveCustomer(model);
            modelMap.addAttribute("alertType", "alert-success");
            modelMap.addAttribute("alertMessage", "Đăng ký thành công!");
        }
        return "registerPage";
    }

}
