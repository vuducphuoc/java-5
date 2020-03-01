package DAO_Test;

import com.laptrinhjava5.minishop.MinishopApplication;
import com.laptrinhjava5.minishop.dao.CategoryDao;
import com.laptrinhjava5.minishop.dao.ProductDao;
import com.laptrinhjava5.minishop.entity.Categorys;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.repository.CategoryRepository;
import org.hibernate.annotations.Proxy;
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
public class ProductTest {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void fillAll_Test() {
        List<Products> lstProd = productDao.fillAll();
        Assert.assertNotNull(lstProd);
    }

    @Test
    public void findById_Test() {
        int id = 1;
        Products prod = productDao.findById(id);

        Assert.assertEquals(prod.getId(), id);
    }

    @Test
    public void findByCategoryId_Test() {
        List<Products> lstProd = productDao.findByCategoryId(1);
        Assert.assertNotNull(lstProd);
    }

    @Test
    public void save_Test() {
        Categorys category = categoryRepository.findById(1).get();
        Products products = new Products("name", 10000, "", category);

        Products prod = productDao.save(products);
        Assert.assertEquals(prod.getId(), products.getId());

        productDao.delete(prod.getId());
    }
}
