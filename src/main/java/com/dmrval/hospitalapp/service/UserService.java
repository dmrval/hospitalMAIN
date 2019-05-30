package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.entity.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);

     List<User> getAllUsers();
}
