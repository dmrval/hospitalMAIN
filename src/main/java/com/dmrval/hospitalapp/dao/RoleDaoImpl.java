package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleDaoImpl implements RoleDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Role findById(int id_role) {
        sessionFactory.getCurrentSession().beginTransaction();
        Role temp = sessionFactory.getCurrentSession().get(Role.class, id_role);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }
}
