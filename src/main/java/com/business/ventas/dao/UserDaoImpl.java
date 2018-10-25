package com.business.ventas.dao;

import com.business.ventas.model.User;

import java.util.List;

public class UserDaoImpl extends AdtractSession implements UserDao {
    @Override
    public List<User> findAll() {
        return getSession().createQuery("from User").list();
    }
}
