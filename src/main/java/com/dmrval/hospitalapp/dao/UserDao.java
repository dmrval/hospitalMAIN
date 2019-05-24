package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
