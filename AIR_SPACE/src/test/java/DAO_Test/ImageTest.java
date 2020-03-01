package DAO_Test;

import com.laptrinhjava5.minishop.MinishopApplication;
import com.laptrinhjava5.minishop.dao.ImageDao;
import com.laptrinhjava5.minishop.entity.Colors;
import com.laptrinhjava5.minishop.entity.Images;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.repository.ColorRepository;
import com.laptrinhjava5.minishop.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MinishopApplication.class})
@Transactional
public class ImageTest {

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Test
    public void findByProduct_Test() {
        Products prod = productRepository.getOne(100);
        List<Images> lstImage = imageDao.findByProduct(prod);
        Assert.assertNotNull(lstImage);
    }

    @Test
    public void findFirstByProductId_Test() {
        int productId = 1;
        Images image = imageDao.findFirstByProductId(productId);

        Assert.assertEquals(image.getProduct().getId(), productId);
    }

    @Test
    public void saveImage_Test() {
        Products prod = productRepository.getOne(1);
        Colors color = colorRepository.getOne(1);
        Images image = new Images("Image Test", color, prod);

        Images actual = imageDao.saveImage(image);

        Assert.assertNotNull(actual);
    }

}
