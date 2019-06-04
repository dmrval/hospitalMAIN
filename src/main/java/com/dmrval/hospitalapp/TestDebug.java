package com.dmrval.hospitalapp;

import com.dmrval.hospitalapp.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestDebug {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        sessionFactory.getCurrentSession().beginTransaction();

        User dm = new User("dmrval","123");
        new Role("ADMIN");
        dm.getRoles().add(new Role("ADMIN"));

        sessionFactory.getCurrentSession().save(dm);

//        CriteriaQuery<Patient> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Patient.class);
//        criteriaQuery.from(Patient.class);
//        List<Patient> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
//        for (Patient r : list) {
//            System.out.println(r.getPatientid());
//            if (r.getPatientid() == 12) {
//                System.out.println(r.getFirstname());
//            }
//        }

        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();


    }
}
