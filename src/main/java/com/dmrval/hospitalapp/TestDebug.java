package com.dmrval.hospitalapp;

import com.dmrval.hospitalapp.entity.Visit;
import org.hibernate.SessionFactory;

public class TestDebug {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        sessionFactory.getCurrentSession().beginTransaction();
        Visit temp = sessionFactory.getCurrentSession().get(Visit.class, 1);
        System.out.println(temp);
    }
}
