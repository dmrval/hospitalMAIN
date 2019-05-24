package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.entity.Role;
import com.dmrval.hospitalapp.entity.User;

public interface UserServise {
    void save(User user);
    User findByLogin(String Login);
}
