package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Doctorlicense;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public class DoctorlicenseDaoImpl implements DoctorlicenseDao {

    @Autowired
    SessionFactory sessionFactory;

    public DoctorlicenseDaoImpl() {
    }

    @Override
    @Transactional
    public Serializable addDoctorlicense(Doctorlicense license) {
        sessionFactory.getCurrentSession().beginTransaction();
        Serializable result = sessionFactory.getCurrentSession().save(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return result;
    }

    @Override
    @Transactional
    public void updateDoctorlicense(Doctorlicense license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void removeDoctorlicense(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(getDoctorlicense(id));
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public Doctorlicense getDoctorlicense(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Doctorlicense temp = sessionFactory.getCurrentSession().get(Doctorlicense.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }



    @Override
    public List<Doctorlicense> getAllDoctorlicense() {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<Doctorlicense> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Doctorlicense.class);
        criteriaQuery.from(Doctorlicense.class);
        List<Doctorlicense> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return list;
    }



}
