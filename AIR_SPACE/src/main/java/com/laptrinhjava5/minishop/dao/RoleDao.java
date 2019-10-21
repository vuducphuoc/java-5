package com.laptrinhjava5.minishop.dao;

import com.laptrinhjava5.minishop.entity.Roles;
import com.laptrinhjava5.minishop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleDao {

    @Autowired
    private RoleRepository roleRepository;

    public Roles findById(Integer id) {
        return roleRepository.findById(id).get();
    }
}
