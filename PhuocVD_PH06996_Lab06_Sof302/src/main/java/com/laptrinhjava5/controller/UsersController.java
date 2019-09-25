package com.laptrinhjava5.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.laptrinhjava5.daoImpl.UsersDaoImpl;
import com.laptrinhjava5.model.UsersDTO;
import com.laptrinhjava5.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping(produces = "application/json; charset=UTF-8")
    public String userDefault(ModelMap modelMap) {
        List<UsersDTO> usersDTOList = usersService.getListUser();
        Gson gson = new Gson();
        String json = gson.toJson(usersDTOList);
        modelMap.addAttribute("list", json);
        return "user";
    }
}
