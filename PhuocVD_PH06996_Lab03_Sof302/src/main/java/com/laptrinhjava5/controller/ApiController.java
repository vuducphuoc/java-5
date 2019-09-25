package com.laptrinhjava5.controller;

import com.laptrinhjava5.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {


    @PostMapping("/insert")
    @ResponseBody
    public String insert(@ModelAttribute Student student, ModelMap modelMap, HttpSession httpSession) {
        List<Student> list = (List<Student>) httpSession.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(student);
        httpSession.setAttribute("list", list);
        return "success";
    }

    @PostMapping("/update/{index}")
    @ResponseBody
    public String update(@ModelAttribute Student student, @PathVariable int index, HttpSession httpSession) {
        List<Student> list = (List<Student>) httpSession.getAttribute("list");
        if (list != null) {
            list.set(index, student);
        }
        httpSession.setAttribute("list", list);
        return "success";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("stt") int stt, HttpSession httpSession) {
        List<Student> list = (List<Student>) httpSession.getAttribute("list");
        if (list != null) {
           list.remove(stt);
        }
        return "success";
    }

}
