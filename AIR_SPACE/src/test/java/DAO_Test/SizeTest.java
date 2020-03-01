package DAO_Test;

import com.laptrinhjava5.minishop.MinishopApplication;
import com.laptrinhjava5.minishop.dao.SizeDao;
import com.laptrinhjava5.minishop.entity.Sizes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MinishopApplication.class})
@Transactional
public class SizeTest {

    @Autowired
    private SizeDao sizeDao;

    @Test
    public void findAll_Test() {
        List<Sizes> lstSize = sizeDao.findAll();
        Assert.assertNotNull(lstSize);
    }

    @Test
    public void findDistinctSizesByProduct_Test() {
        Set<Sizes> lstSize = sizeDao.findDistinctSizesByProduct(1);
        Assert.assertNull(lstSize);
    }

    @Test
    public void findDistinctSizesByProductAndColor_Test() {
        Set<Sizes> lstSize = sizeDao.findDistinctSizesByProductAndColor(1, 1);
        Assert.assertNotNull(lstSize);
    }

    @Test
    public void findById_Test() {
        int id = 1;
        Sizes size = sizeDao.findById(id);
        Assert.assertEquals(size.getId(), id);
    }
}
