package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Users;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableAspectJAutoProxy
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findOneByEmailAndStatus(String name, int status);

    Users findByEmail(String email);

    Users findByEmailAndPassword(String email, String password);
}
