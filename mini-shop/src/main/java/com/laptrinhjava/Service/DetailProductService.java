package com.laptrinhjava.Service;

import com.laptrinhjava.Dao.DaoImpl.DetailProductDaoImpl;
import com.laptrinhjava.Entity.Color;
import com.laptrinhjava.Entity.Detail_Product;
import com.laptrinhjava.Entity.Product;
import com.laptrinhjava.Entity.Size;
import com.laptrinhjava.Model.ColorDTO;
import com.laptrinhjava.Model.DetailProductDTO;
import com.laptrinhjava.Model.SizeDTO;
import com.laptrinhjava.ModelUtils.ColorBeanUtil;
import com.laptrinhjava.ModelUtils.DetailProductBeanUtil;
import com.laptrinhjava.ModelUtils.SizeBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DetailProductService {
    @Autowired
    DetailProductDaoImpl detailProductDao;

    public List<DetailProductDTO>  getByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, String whereClause) {
        List<Detail_Product> list = (List<Detail_Product>) detailProductDao.findByProperty(property,sortExpression,sortDirection,offset,limit,whereClause)[1];
        return DetailProductBeanUtil.listEntity2ListDto(list);
    }

    public DetailProductDTO getSingleResult(int idProduct, int idColor, int idSize) {
        Detail_Product entity = detailProductDao.getSingleResult(idProduct,idColor,idSize);
        return DetailProductBeanUtil.entity2Dto(entity);
    }

    public List<DetailProductDTO> getListDetailByProduct(Product product) {
        return DetailProductBeanUtil.listEntity2ListDto(detailProductDao.getListByProduct(product));
    }

    public List<SizeDTO> getListSize(Product product) {
        List<Size> sizeList = detailProductDao.getListSize(product);
        return SizeBeanUtil.listEntity2ListDto(sizeList);
    }

    public List<ColorDTO> getListColor(Product product) {
        List<Color> colorList = detailProductDao.getListColor(product);
        return ColorBeanUtil.listEntity2ListDto(colorList);
    }

}
