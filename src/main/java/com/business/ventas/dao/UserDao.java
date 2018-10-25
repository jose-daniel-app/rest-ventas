package com.business.ventas.dao;

import com.business.ventas.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
