package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Users;
import com.laptrinhjava5.minishop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public void save(Users user) {
        userRepository.save(user);
    }

    public Users findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public Users findByEmailAndPassword(String email, String password) {
        Users user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
