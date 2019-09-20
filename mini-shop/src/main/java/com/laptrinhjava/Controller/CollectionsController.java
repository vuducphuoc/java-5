package com.laptrinhjava.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/collections")
public class CollectionsController {

    @GetMapping
    public String search(@RequestParam String txtSearch) {
        return "product/collections";
    }

    @GetMapping("/{value}")
    public String getCollections(@PathVariable String value, @MatrixVariable String id ){
        return "product/collections";
    }

    @GetMapping("/search")
    public String getCollectionsSearch(@MatrixVariable String s ){
        System.out.println(s);
        return "product/collections";
    }
}
