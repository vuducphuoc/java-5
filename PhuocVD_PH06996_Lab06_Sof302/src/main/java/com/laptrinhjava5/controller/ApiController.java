package com.laptrinhjava5.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjava5.dto.UsersBeanUtil;
import com.laptrinhjava5.entity.Users;
import com.laptrinhjava5.model.UsersDTO;
import com.laptrinhjava5.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ApiController {
    @Autowired
    UsersService usersService;

    // Trả ra chuỗi JSON dùng produces = "application/json; charset=UTF-8"
    // Lưu ý: produces áp dụng cho toàn bộ class, khi muốn truyền text phải khai báo produces="text/html" hoặc "text/plain"

    @PostMapping(path = "/save", produces="application/json; charset=UTF-8")
    @ResponseBody
    public UsersDTO action(@ModelAttribute Users users) {
        Users entity = new Users(users.getUsername(), users.getPassword(), users.getFullname());
        entity = usersService.save(entity);
        UsersDTO dto = UsersBeanUtil.entity2Dto(entity);

//        Users check = new Users();

//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode;
//        try {
//            jsonNode = objectMapper.readTree(dataJson);
//            int id = jsonNode.get("id").asInt();
//            String username = jsonNode.get("username").asText();
//            String password = jsonNode.get("password").asText();
//            String fullname = jsonNode.get("fullname").asText();
//
//            Users users = new Users(username, password, fullname);
//
//            if (action.equalsIgnoreCase("insert")) {
//                check = usersService.save(users);
//            } else if (action.equalsIgnoreCase("update")) {
//                users.setId(id);
//                check = usersService.update(users);
//            } else if (action.equalsIgnoreCase("delete")) {
//                List<Integer> listID = new ArrayList<>();
//                listID.add(id);
//                usersService.delete(listID);
//            }
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

        return dto;
    }
}
