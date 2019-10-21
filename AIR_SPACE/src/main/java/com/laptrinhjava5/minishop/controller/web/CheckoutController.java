package com.laptrinhjava5.minishop.controller.web;

import com.laptrinhjava5.minishop.model.BillsVO;
import com.laptrinhjava5.minishop.model.MyCart;
import com.laptrinhjava5.minishop.model.UserVO;
import com.laptrinhjava5.minishop.service.BillDetailService;
import com.laptrinhjava5.minishop.service.BillService;
import com.laptrinhjava5.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    @Autowired
    private BillDetailService billDetailService;

    @GetMapping
    public String checkoutDefault(HttpSession httpSession, ModelMap modelMap) {
        UserVO userLogin = (UserVO) httpSession.getAttribute("userLogin");
        if (userLogin == null) {
            return "redirect:login";
        } else {
            return "checkoutPage";
        }
    }

    @PostMapping("/api/checkout-action")
    @ResponseBody
    public String checkOut(@ModelAttribute BillsVO bill, HttpSession httpSession) {
        UserVO userLogin = (UserVO) httpSession.getAttribute("userLogin");
        bill.setUser(userLogin);

        List<MyCart> myCartList = (List<MyCart>) httpSession.getAttribute("myCartList");

        billService.saveBills(bill, myCartList);

        httpSession.removeAttribute("myCartList");
        return "success";
    }

}
