package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.UserDao;
import com.dmrval.hospitalapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);

    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
