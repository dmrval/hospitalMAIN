package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.RoleDao;
import com.dmrval.hospitalapp.dao.UserDao;
import com.dmrval.hospitalapp.entity.Role;
import com.dmrval.hospitalapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class UserServiseImpl implements UserServise{

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDao.getOne(1));
        user.setRoles(roleSet);
        userDao.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByUsername(login);
    }
}
