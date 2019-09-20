package com.laptrinhjava.Controller;

import com.laptrinhjava.Model.AccountDTO;
import com.laptrinhjava.Service.AccountService;
import com.laptrinhjava.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public String RegisterDefault(ModelMap modelMap) {
        return "web/register";
    }

    @PostMapping
    public String register(@ModelAttribute AccountDTO model, ModelMap modelMap) {
        boolean check = accountService.checkEmailExist(model.getEmail());
        if (check) {
            modelMap.addAttribute("alertType", "alert-warning");
            modelMap.addAttribute("alertMessage", "Email đã tồn tại!");
        } else {
            AccountDTO dto = new AccountDTO(model.getName(), model.getEmail(), model.getPassword(), model.getPhone());
            dto = accountService.save(dto);
            if (dto != null) {
                modelMap.addAttribute("alertType", "alert-success");
                modelMap.addAttribute("alertMessage", "Đăng ký thành công!");
            } else {
                modelMap.addAttribute("alertType", "alert-warning");
                modelMap.addAttribute("alertMessage", "Lỗi hệ thống. Vui lòng thử lại!");
            }
        }
        return "web/register";
    }

}
