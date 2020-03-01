package com.laptrinhjava5.minishop.controller.admin;

import com.google.gson.Gson;
import com.laptrinhjava5.minishop.model.BillsVO;
import com.laptrinhjava5.minishop.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminBillController {

    @Autowired
    private BillService billService;

    @GetMapping("/hoa-don")
    public String getDefault(ModelMap modelMap) {
        List<BillsVO> billsVOList = billService.findAll();

        String jsonBill = new Gson().toJson(billsVOList);

        modelMap.addAttribute("billList", jsonBill);
        return "adminBillPage";
    }
}
