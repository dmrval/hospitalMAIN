package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.User;

import java.util.List;

public interface UserDao {
    User findByLogin(String login);

    List<User> getAllUsers();

    User getUser(int id);

}
