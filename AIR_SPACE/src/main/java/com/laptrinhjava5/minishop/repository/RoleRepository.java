package com.laptrinhjava5.minishop.repository;

import com.laptrinhjava5.minishop.entity.Categorys;
import com.laptrinhjava5.minishop.entity.Roles;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableAspectJAutoProxy
public interface RoleRepository extends JpaRepository<Roles, Integer> {

    Roles findByName(String name);

    @Query(value = "SELECT *  FROM Roles INNER JOIN Users_Roles UR on Roles.id = UR.roleID WHERE ur.userID = :userId"
            , nativeQuery = true)
    List<Roles> getAllByUserId(@Param("userId") int userId);

}
