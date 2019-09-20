package com.laptrinhjava.Controller;

import com.laptrinhjava.Model.*;
import com.laptrinhjava.Service.*;
import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Entity.Product;
import com.laptrinhjava.Entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"api/", "product/api/"})
public class ApiController {

    @Autowired
    ProductService productService;

    @Autowired
    DetailProductService detailProductService;

    @Autowired
    SizeService sizeService;

    @Autowired
    ColorService colorService;

    @Autowired
    BillService billService;

    @Autowired
    DetailBillService detailBillService;

    @PostMapping("add-to-cart")
    @ResponseBody
    public String addToCart(@ModelAttribute DataCart dataCart, HttpSession httpSession) {
        boolean flagProductExist = false;

        int idProduct = dataCart.getIdProduct();
        int idColor = dataCart.getIdColor();
        int idSize = dataCart.getIdSize();
        int quantity = dataCart.getQuantity();

        ProductDTO product = productService.getById(idProduct);
        SizeDTO size = new SizeDTO();
        ColorDTO color = new ColorDTO();

        if (idColor != 0) {
            color = colorService.getById(idColor);
        } else {
            color = product.getColorList().get(0);
        }

        if (idSize != 0) {
            size = sizeService.getById(idSize);
        } else {
            size = product.getSizeList().get(0);
        }

        if (quantity == 0) {
            quantity = 1;
        }

        List<DataCart> listItemCart = (List<DataCart>) httpSession.getAttribute("listItemCart");

        DetailProductDTO detailProductDTO = detailProductService.getSingleResult(product.getId(), color.getId(), size.getId());

        if (listItemCart != null){
            for (DataCart item : listItemCart){
                int quantityOld = item.getQuantity();
                if (item.getIdProduct() == product.getId() && color.getId() == item.getIdColor() && size.getId() == item.getIdSize()){
                    item.setQuantity(quantityOld+quantity);
                    flagProductExist = true;
                    break;
                }
            }
        } else {
            listItemCart = new ArrayList<>();
        }

        if (flagProductExist == false){
            DataCart dataCart1 = new DataCart();

            dataCart1.setIdProduct(product.getId());
            dataCart1.setIdSize(size.getId());
            dataCart1.setIdColor(color.getId());

            dataCart1.setDetailProduct(detailProductDTO);
            dataCart1.setProduct(product);
            dataCart1.setSize(size);
            dataCart1.setColor(color);

            dataCart1.setQuantity(quantity);
            listItemCart.add(dataCart1);
        }

        httpSession.setAttribute("listItemCart", listItemCart);
        return ""+listItemCart.size();
    }

    @PostMapping("delete-from-cart")
    @ResponseBody
    public String deleteFromCart(@ModelAttribute DataCart dataCart, HttpSession httpSession) {

        int idProduct = dataCart.getIdProduct();
        int idColor = dataCart.getIdColor();
        int idSize = dataCart.getIdSize();

        List<DataCart> listItemCart = (List<DataCart>) httpSession.getAttribute("listItemCart");
        for (DataCart item : listItemCart){
            int quantityOld = item.getQuantity();
            if (item.getIdProduct() == idProduct && idColor == item.getIdColor() && idSize == item.getIdSize()){
                listItemCart.remove(item);
                break;
            }
        }

        return ""+listItemCart.size();
    }

    @PostMapping("update-to-cart")
    @ResponseBody
    public void updateToCart(@RequestParam("quantitys") String quantitys, HttpSession httpSession) {
        List<DataCart> listItemCart = (List<DataCart>) httpSession.getAttribute("listItemCart");
        String[] items = quantitys.split(",");
        for (int i = 0; i < items.length; i++){
            listItemCart.get(i).setQuantity(Integer.parseInt(items[i]));
        }
    }

    @PostMapping("checkout")
    public String checkoutSuccess(@ModelAttribute BillDTO billDTO, HttpSession httpSession, ModelMap modelMap) {
        List<DataCart> listItemCart = (List<DataCart>) httpSession.getAttribute("listItemCart");
        AccountDTO accountLogin = (AccountDTO) httpSession.getAttribute("accountLogin");

        billDTO.setAccount(accountLogin);
        billDTO = billService.save(billDTO);

        for (DataCart item : listItemCart) {
            DetailBillDTO detailBillDTO = new DetailBillDTO();
            detailBillDTO.setDetailProduct(item.getDetailProduct());
            detailBillDTO.setNumber(item.getQuantity());
            detailBillDTO.setPrice(item.getTotalPrice());
            detailBillDTO.setBillDTO(billDTO);
            detailBillService.save(detailBillDTO);
        }
        return "success";
    }
}
