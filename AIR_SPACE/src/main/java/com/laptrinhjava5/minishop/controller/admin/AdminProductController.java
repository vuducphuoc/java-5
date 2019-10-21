package com.laptrinhjava5.minishop.controller.admin;

import com.google.gson.Gson;
import com.laptrinhjava5.minishop.model.*;
import com.laptrinhjava5.minishop.service.CategoryService;
import com.laptrinhjava5.minishop.service.ColorService;
import com.laptrinhjava5.minishop.service.ImageService;
import com.laptrinhjava5.minishop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    ServletContext context;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/san-pham")
    public String getDefault(ModelMap modelMap) {
        List<CategorysVO> categorysVOList = categoryService.fillAll();
        List<ProductsVO> productsVOList = productService.findAll();
        List<ColorsVO> colorsVOList = colorService.findAll();

        String jsonProduct = new Gson().toJson(productsVOList);
        String jsonCategory = new Gson().toJson(categorysVOList);
        String jsonColor = new Gson().toJson(colorsVOList);

        modelMap.addAttribute("productList", jsonProduct);
        modelMap.addAttribute("categoryList", jsonCategory);
        modelMap.addAttribute("colorList", jsonColor);
        return "productPage";
    }

    @PostMapping("/api/save-product")
    @ResponseBody
    public String save(@ModelAttribute ProductsVO vo) {
        ProductsVO result = productService.saveOrUpdate(vo);
        String jsonProduct = new Gson().toJson(result);
        return jsonProduct;
    }

    @PostMapping("/api/delete-product")
    @ResponseBody
    public void delete(@RequestParam Integer id) {
        productService.delete(id);
    }

    @PostMapping("/api/edit-image")
    @ResponseBody
    public String editImage(@RequestParam Integer id) {
        List<ImagesVO> imagesVOList = imageService.findByProductId(id);
        List<ColorsVO> colorsVOList = colorService.findDistinctColorsByProduct(id);

        Map<String, Object> map = new HashMap<>();
        map.put("images", imagesVOList);
        map.put("colors", colorsVOList);

        String json = new Gson().toJson(map);
        return json;
    }

    @PostMapping("/api/save-change-image")
    @ResponseBody
    public String saveChangeImage(@RequestParam("images[]") Integer[] images, @RequestParam("colors[]") Integer[] colors ) {
        imageService.saveChangeImage(images, colors);
        Map<String, Object> map = new HashMap<>();
        map.put("error", "success");

        String json = new Gson().toJson(map);
        return json;
    }

    @PostMapping("/api/upload-image")
    @ResponseBody
    public String uploadImage(@RequestParam MultipartFile image, @RequestParam Integer productId, @RequestParam Integer colorId) {
        String jsonResutl = null;
        try {
            String folderPath = context.getRealPath("/resources/images/" + productId);
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            String uploadPath = folderPath + "/" + image.getOriginalFilename();
            File upload = new File(uploadPath);
            image.transferTo(upload);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResutl;
    }

    @PostMapping("/api/add-new-image")
    @ResponseBody
    public String addNewImage(@RequestParam String name, @RequestParam Integer productId, @RequestParam Integer colorId) {
        name = productId + "/" + name;

        ImagesVO imagesVO = imageService.saveImage(name, productId, colorId);
        ResultValue resultValue = null;

        if (imagesVO == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", "Ảnh sản phẩm đã tồn tại !");
            resultValue = new ResultValue(null, error);
        } else {
            resultValue = new ResultValue(imagesVO, null);
        }

        return new Gson().toJson(resultValue);
    }

    @PostMapping("/api/delete-image")
    @ResponseBody
    public void deleteImage(@RequestParam Integer id) {
        imageService.deleteImage(id);
    }
}
