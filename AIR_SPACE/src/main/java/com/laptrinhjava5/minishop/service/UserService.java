package com.laptrinhjava5.minishop.service;

import com.laptrinhjava5.minishop.dao.RoleDao;
import com.laptrinhjava5.minishop.dao.UserDao;
import com.laptrinhjava5.minishop.entity.Roles;
import com.laptrinhjava5.minishop.entity.Users;
import com.laptrinhjava5.minishop.model.UserVO;
import com.laptrinhjava5.minishop.repository.RoleRepository;
import com.laptrinhjava5.minishop.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserVO> findAll() {
        List<Users> users = userRepository.findAll();
        List<UserVO> userVOS = new ArrayList<>();

        for (Users item : users) {
            Integer[] roleList = new Integer[item.getRolesList().size()];
            for (int i=0; i<item.getRolesList().size(); i++) {
                roleList[i] = item.getRolesList().get(i).getId();
            }
            UserVO userVO = new UserVO(item.getId(), item.getName(), item.getEmail(),
                    null, item.getStatus(),  roleList);
            userVOS.add(userVO);
        }
        return userVOS;
    }

    public UserVO getOne(int id) {
        Users users = userRepository.getOne(id);
        List<Roles> rolesList = roleRepository.getAllByUserId(users.getId());

        Integer[] roles = new Integer[rolesList.size()];
        for (int i=0; i< rolesList.size(); i++) {
            roles[i] = rolesList.get(i).getId();
        }

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(users, userVO);
        userVO.setRoles(roles);
        return userVO;
    }

    public UserVO findUserByEmail(String email) {
        Users user = userRepository.findByEmail(email);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    public UserVO saveUser(UserVO userVO) {

        Users user = new Users();
        BeanUtils.copyProperties(userVO, user);
        user.setPassword(bCryptPasswordEncoder.encode(userVO.getPassword()));
        user.setStatus(userVO.getStatus());
        user.setRolesList(getRolesListByUserVO(userVO));

        userRepository.save(user);

        UserVO result = new UserVO();
        BeanUtils.copyProperties(user,result );
        result.setRoles(userVO.getRoles());

        return result;
    }

    public UserVO updateUser(UserVO userVO) {
        Users user = userRepository.getOne(userVO.getId());

        user.setName(userVO.getName());
        user.setEmail(userVO.getEmail());
        if (userVO.getPassword().length() != 0) {
            user.setPassword(bCryptPasswordEncoder.encode(userVO.getPassword()));
        }
        user.setStatus(userVO.getStatus());
        user.setRolesList(getRolesListByUserVO(userVO));

        userRepository.saveAndFlush(user);

        UserVO result = new UserVO();
        BeanUtils.copyProperties(user,result );
        result.setRoles(userVO.getRoles());
        return result;
    }

    public void saveCustomer(UserVO userVO) {
        Users user = new Users();
        user.setName(userVO.getName());
        user.setEmail(userVO.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userVO.getPassword()));
        user.setStatus(1);

        Roles role = roleDao.findById(2);

        List<Roles> rolesList = new ArrayList<>();
        rolesList.add(role);

        user.setRolesList(rolesList);

        userRepository.save(user);
    }

    public boolean checkEmailExist(String email) {
        Users user = userRepository.findByEmail(email);
        if (user != null) {
            return  true;
        } else {
            return false;
        }
    }

    public boolean checkChangePassword(String email, String password) {
        Users user = userDao.findByEmail(email);
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public void changePassword(String email, String oldPassword, String newPassword) {
        Users user = userDao.findByEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userDao.save(user);
    }

    public List<Roles> getRolesListByUserVO(UserVO userVO) {
        List<Roles> rolesList = new ArrayList<>();
        for (int i=0; i < userVO.getRoles().length; i++) {
            int idRole = (userVO.getRoles()[i]);
            Roles role = roleRepository.getOne(idRole);
            rolesList.add(role);
        }
        return rolesList;
    }



}
