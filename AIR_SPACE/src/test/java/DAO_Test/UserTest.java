package DAO_Test;

import com.laptrinhjava5.minishop.MinishopApplication;
import com.laptrinhjava5.minishop.dao.UserDao;
import com.laptrinhjava5.minishop.entity.Users;
import com.laptrinhjava5.minishop.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MinishopApplication.class})
@Transactional
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void findByEmail_Test() {
        String email = "admin@gmail.com";
        Users actual = userDao.findByEmail(email);
        Assert.assertEquals(actual.getEmail(), email);
    }

    @Test
    public void findById_Test() {
        int id = 1;
        Users actual = userDao.findById(1);
        Assert.assertEquals(actual.getId(), id);
    }

    @Test
    public void findByEmailAndPassword_Test() {
        String email = "admin@gmail.com";
        String password = "123456";
        Users actual = userDao.findByEmailAndPassword(email, bCryptPasswordEncoder.encode(password));
        Assert.assertNotNull(actual);
    }

    @Test
    public void save_Test() {
        Users user = new Users("Vu Duc Phuoc", "vuducphuoc@gmail.com", bCryptPasswordEncoder.encode("123456"), 1);
        Users actual = userDao.save(user);
        Assert.assertEquals(user.getEmail(), actual.getEmail());
        userRepository.delete(actual);
    }

}
