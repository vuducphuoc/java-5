package Services_Test;

import com.laptrinhjava5.minishop.MinishopApplication;
import com.laptrinhjava5.minishop.repository.ProductRepository;
import com.laptrinhjava5.minishop.service.ProductService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest(classes = {MinishopApplication.class})
public class Product_Test {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void findAll_Test() {
        int count = productRepository.findAll().size();

        int actualCount = productService.findAll().size();
        Assert.assertEquals(count, actualCount);
    }

}
