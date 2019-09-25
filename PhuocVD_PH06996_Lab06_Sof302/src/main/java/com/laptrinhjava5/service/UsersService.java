package com.laptrinhjava5.service;

import com.laptrinhjava5.dao.UsersDao;
import com.laptrinhjava5.daoImpl.UsersDaoImpl;
import com.laptrinhjava5.dto.UsersBeanUtil;
import com.laptrinhjava5.entity.Users;
import com.laptrinhjava5.model.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UsersService implements UsersDao {

    @Autowired
    UsersDaoImpl usersDaoImpl;

    public List<UsersDTO> getListUser() {
        List<UsersDTO> usersDTOList = new ArrayList<>();
        List<Users> usersList = findAll();
        for (Users item : usersList) {
            UsersDTO usersDTO = UsersBeanUtil.entity2Dto(item);
            usersDTOList.add(usersDTO);
        }
        return usersDTOList;
    }

    @Override
    public List<Users> findAll() {
        return usersDaoImpl.findAll();
    }

    @Override
    public Users update(Users entity) {
        return usersDaoImpl.update(entity);
    }

    @Override
    public Users save(Users entity) {
        return usersDaoImpl.save(entity);
    }

    @Override
    public Users findById(Integer var1) {
        return usersDaoImpl.findById(var1);
    }

    @Override
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, String whereClause) {
        return usersDaoImpl.findByProperty(property,sortExpression,sortDirection,offset,limit,whereClause);
    }

    @Override
    public Integer delete(List<Integer> integers) {
        return usersDaoImpl.delete(integers);
    }

    @Override
    public Users findEqualUnique(String property, Object value) {
        return usersDaoImpl.findEqualUnique(property,value);
    }
}
