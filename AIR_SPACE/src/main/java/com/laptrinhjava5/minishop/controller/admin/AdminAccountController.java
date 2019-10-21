package com.laptrinhjava5.minishop.controller.admin;

import com.google.gson.Gson;
import com.laptrinhjava5.minishop.model.UserVO;
import com.laptrinhjava5.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminAccountController {

    @Autowired
    UserService userService;

    @GetMapping("/tai-khoan")
    public String accountManager(ModelMap modelMap) {
        List<UserVO> userVOList = userService.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(userVOList);

        modelMap.addAttribute("userList", json);
        return "adminAccountPage";
    }

    @PostMapping("/api/edit-user")
    @ResponseBody
    public UserVO editUser(@RequestParam String userId) {
        int id = Integer.parseInt(userId);
        UserVO userVO = userService.getOne(id);
        return userVO;
    }


    @PostMapping("/api/save-user")
    @ResponseBody
    public UserVO saveUser(@ModelAttribute UserVO userVO ) {
        UserVO result = userService.saveUser(userVO);
        return result;
    }

    @PostMapping("/api/update-user")
    @ResponseBody
    public UserVO updateUser(@ModelAttribute UserVO userVO) {
        UserVO result = userService.updateUser(userVO);
        return result;
    }
}
