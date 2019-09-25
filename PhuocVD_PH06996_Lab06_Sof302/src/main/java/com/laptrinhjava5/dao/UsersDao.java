package com.laptrinhjava5.dao;

import com.laptrinhjava5.entity.Users;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public interface UsersDao extends GenericDao<Integer, Users> {
}
