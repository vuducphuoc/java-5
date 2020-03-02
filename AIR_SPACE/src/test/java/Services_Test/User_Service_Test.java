package Services_Test;

import com.laptrinhjava5.minishop.MinishopApplication;
import com.laptrinhjava5.minishop.entity.Users;
import com.laptrinhjava5.minishop.model.UserVO;
import com.laptrinhjava5.minishop.repository.UserRepository;
import com.laptrinhjava5.minishop.service.UserService;
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
public class User_Service_Test {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void findAll() {
        int actual = userRepository.findAll().size();
        int expect = userService.findAll().size();

        Assert.assertEquals(actual, expect);
    }

    @Test
    public void getOne() {
        int id = 1;
        String actual = userRepository.getOne(id).getEmail();
        String expect = userService.getOne(id).getEmail();

        Assert.assertEquals(actual, expect);
    }

    @Test
    public void findUserByEmail() {
        String email = "admin@gmail.com";

        int actual = userRepository.findByEmail(email).getId();
        int expect = userService.findUserByEmail(email).getId();
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void saveUser() {
//        String name, String email, String password, int status, Integer[] roles)
        UserVO userVO = new UserVO("Test", "test@gmail.com", "123456", 1, new Integer[]{1});

        UserVO actual = userService.saveUser(userVO);

        Assert.assertNotNull(actual);

        userRepository.deleteById(actual.getId());
    }

    @Test
    public void updateUser() {
        UserVO userVO = new UserVO("Test", "test123@gmail.com", "123456", 1, new Integer[]{1});
        userVO = userService.saveUser(userVO);

        String expect = "Update Success";
        userVO.setName(expect);

        userVO = userService.updateUser(userVO);

        Assert.assertEquals(userVO.getName(), expect);

        userRepository.deleteById(userVO.getId());

    }

    @Test
    public void saveCustomer() {

    }

    @Test
    public void checkEmailExist() {
        String email = "admin@gmail.com";
        boolean actual = userService.checkEmailExist(email);

        Assert.assertTrue(actual);
    }

    @Test
    public void checkChangePassword() {
        String email = "admin@gmail.com";
        String password = "123456";

        Assert.assertTrue(userService.checkChangePassword(email, password));
    }

    public void changePassword() {

    }

    public void getRolesListByUserVO(UserVO userVO) {

    }
}
