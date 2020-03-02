package Services_Test;

import com.laptrinhjava5.minishop.MinishopApplication;
import com.laptrinhjava5.minishop.entity.Products;
import com.laptrinhjava5.minishop.model.ProductsVO;
import com.laptrinhjava5.minishop.repository.ProductRepository;
import com.laptrinhjava5.minishop.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MinishopApplication.class})
@Transactional
public class Product_Test {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @org.junit.jupiter.api.Test
    public void findAll_Test() {
        int count = productRepository.findAll().size();

        int actualCount = productService.findAll().size();
        Assert.assertEquals(count, actualCount);
    }

    @Test
    public void findById_Test () {
        int id = 1;
        Products db = productRepository.findById(id).get();
        ProductsVO vo = productService.findById(id);

        Assert.assertEquals(db.getName(), vo.getName());
    }

    @Test
    public void findByCategoryId_Test() {
        int categoryId = 1;
        int actual = productRepository.findByCategoryId(categoryId).size();
        int expect = productService.findByCategoryId(categoryId).size();

        Assert.assertEquals(actual, expect);
    }

    @Test
    public void findByNameLike_Test() {
        String name = "Áo";
        int actual = productRepository.findByNameContainingIgnoreCase(name).size();
        int expect = productService.findByNameLike(name).size();

        Assert.assertEquals(actual, expect);
    }

}
