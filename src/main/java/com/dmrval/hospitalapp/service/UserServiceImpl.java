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

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public boolean userLoginIsExist(User u) {
        List<User> userList = getAllUsers();
        for (User tmp:userList) {
            if (tmp.getLogin().equals(u.getLogin())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
