package com.laptrinhjava.Service;

import com.laptrinhjava.Dao.DaoImpl.AccountDaoImpl;
import com.laptrinhjava.Entity.Account;
import com.laptrinhjava.Model.AccountDTO;
import com.laptrinhjava.ModelUtils.AccountBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountDaoImpl accountDaoImpl;

    public AccountDTO checkLogin(String email, String password) {
        Account entity = accountDaoImpl.checkLogin(email, password);
       return AccountBeanUtil.entity2Dto(entity);
    }

    public AccountDTO save(AccountDTO dto) {
        Account entity = AccountBeanUtil.dto2Entity(dto);
        entity = accountDaoImpl.save(entity);
        return AccountBeanUtil.entity2Dto(entity);
    }

    public boolean checkEmailExist(String email) {
        return accountDaoImpl.checkEmailExist(email);
    }

}
