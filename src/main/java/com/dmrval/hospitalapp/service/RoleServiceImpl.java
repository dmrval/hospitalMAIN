package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.RoleDao;
import com.dmrval.hospitalapp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleSevice {

    @Autowired
    RoleDao roleDao;

    @Override
    public Role findById(int id_role) {
        return roleDao.findById(id_role);
    }
}
