package com.laptrinhjava.Controller;

import com.laptrinhjava.Model.AccountDTO;
import com.laptrinhjava.Model.BillDTO;
import com.laptrinhjava.Model.DataCart;
import com.laptrinhjava.Model.DetailBillDTO;
import com.laptrinhjava.Service.BillService;
import com.laptrinhjava.Service.DetailBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @GetMapping
    public String checkoutDefault() {
        return "blank/checkout";
    }


}
