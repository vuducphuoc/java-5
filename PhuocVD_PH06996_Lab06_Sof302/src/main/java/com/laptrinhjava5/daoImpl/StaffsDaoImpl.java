package com.laptrinhjava5.daoImpl;


import com.laptrinhjava5.dao.AbstractDao;
import com.laptrinhjava5.dao.StaffsDao;
import com.laptrinhjava5.dao.UsersDao;
import com.laptrinhjava5.entity.Staffs;
import com.laptrinhjava5.entity.Users;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StaffsDaoImpl extends AbstractDao<Integer, Staffs> implements StaffsDao {
}
