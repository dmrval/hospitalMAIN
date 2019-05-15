package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Visit;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class VisitDaoImpl implements VisitDao {
    @Autowired
    SessionFactory sessionFactory;


    public VisitDaoImpl() {
    }

    @Override
    @Transactional
    public void addVisit(Visit license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void updateVisit(Visit license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void removeVisit(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(getVisitPrivate(id));
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public Visit getVisit(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Visit temp = sessionFactory.getCurrentSession().get(Visit.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }

    @Override
    public List<Visit> getAllVisit() {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<Visit> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Visit.class);
        criteriaQuery.from(Visit.class);
        List<Visit> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return list;
    }


    //PRIVATE only this class use=))
    private Visit getVisitPrivate(int id) {
        Visit temp = sessionFactory.getCurrentSession().get(Visit.class, id);
        return temp;
    }


}
