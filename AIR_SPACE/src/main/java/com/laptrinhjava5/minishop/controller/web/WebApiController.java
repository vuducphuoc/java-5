package com.laptrinhjava5.minishop.controller.web;

import com.laptrinhjava5.minishop.model.*;
import com.laptrinhjava5.minishop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebApiController {

    @Autowired
    private SizeService sizeService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailService productDetailService;

    @PostMapping(value = "/getProductDetail")
    public List<Product_DetailsVO> getProductDetail(@RequestParam String proID, @RequestParam String colID) {
        int productID = Integer.parseInt(proID);
        int colorID = Integer.parseInt(colID);
        List<Product_DetailsVO> productDetailsVOList = productDetailService.findByProductAndColor(productID, colorID);
        return productDetailsVOList;
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam(required = true) Integer productID,
                            @RequestParam(required = false) Integer colorID,
                            @RequestParam(required = false) Integer sizeID,
                            @RequestParam(required = false) Integer quantity
                            , HttpSession httpSession) {

        boolean cartEmpty = true;

        MyCart newMyCart = addNewMyCart(productID, colorID, sizeID, quantity);

        List<MyCart> myCartList = (List<MyCart>) httpSession.getAttribute("myCartList");

        if (myCartList != null){
            for (MyCart item : myCartList){
                int quantityOld = item.getQuantity();

                if (item.getProductID().equals(newMyCart.getProductID())
                        && item.getColorID().equals(newMyCart.getColorID())
                        && item.getSizeID().equals(newMyCart.getSizeID())) {

                    item.setQuantity(quantityOld + newMyCart.getQuantity());
                    cartEmpty = false;
                    break;
                }
            }
        }
        else {
            myCartList = new ArrayList<>();
        }

        if (cartEmpty == true) {
            myCartList.add(newMyCart);
        }

        httpSession.setAttribute("myCartList", myCartList);
        return String.valueOf(myCartList.size());
    }

    @PostMapping("/delete-from-cart")
    public String deleteFromCart(@ModelAttribute MyCart myCart, HttpSession httpSession) {
        List<MyCart> myCartList = (List<MyCart>) httpSession.getAttribute("myCartList");

        for (MyCart item : myCartList){
            if (item.getProductID().equals(myCart.getProductID())
                    && item.getColorID().equals(myCart.getColorID())
                    && item.getSizeID().equals(myCart.getSizeID())){
                myCartList.remove(item);
                break;
            }
        }

        return String.valueOf(myCartList.size());
    }

    @PostMapping("/update-cart")
    public void updateToCart(@RequestParam("quantitys") String quantitys, HttpSession httpSession) {
        List<MyCart> myCartList = (List<MyCart>) httpSession.getAttribute("myCartList");

        String[] items = quantitys.split(",");
        for (int i = 0; i < items.length; i++){
            myCartList.get(i).setQuantity(Integer.parseInt(items[i]));
        }
    }

    public MyCart addNewMyCart(Integer productId, Integer colorId, Integer sizeId, Integer quantity) {

        ProductsVO productsVO = productService.findById(productId);

        ColorsVO colorsVO = new ColorsVO();
        SizesVO sizesVO = new SizesVO();

        if (colorId == null) {
            colorsVO = colorService.findDistinctColorsByProduct(productsVO.getId()).get(0);
        } else {
            colorsVO = colorService.findById(colorId);
        }
        if (sizeId == null) {
            sizesVO = sizeService.findDistinctSizesByProductAndColor(productsVO.getId(), colorsVO.getId()).get(0);
        } else {
            sizesVO = sizeService.findById(sizeId);
        }
        if (quantity == null) {
            quantity = 1;
        }

        MyCart newMyCart = new MyCart(productsVO.getId(), colorsVO.getId(), sizesVO.getId() , productsVO, colorsVO, sizesVO, quantity);
        return newMyCart;
    }
}
