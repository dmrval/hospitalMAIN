package com.dmrval.hospitalapp;

import com.dmrval.hospitalapp.entity.Role;
import com.dmrval.hospitalapp.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class TestDebug {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        sessionFactory.openSession();
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<User> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        List<User> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();

        User result = null;
        for (User u:list) {
            if (u.getLogin().equals("dmrval")) {
                result = u;
            }
        }


        for (Role r: result.getRoles()) {
            System.out.println(r.getRolename());
        }

        System.out.println(result.getLogin() + result.getPassword() );
    }
}
