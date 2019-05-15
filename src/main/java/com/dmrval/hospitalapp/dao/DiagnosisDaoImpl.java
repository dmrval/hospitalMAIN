package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Diagnosis;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class DiagnosisDaoImpl implements DiagnosisDao{
    @Autowired
    SessionFactory sessionFactory;


    public DiagnosisDaoImpl() {
    }

    @Override
    @Transactional
    public void addDiagnosis(Diagnosis license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void updateDiagnosis(Diagnosis license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void removeDiagnosis(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(getDiagnosis(id));
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public Diagnosis getDiagnosis(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Diagnosis temp = sessionFactory.getCurrentSession().get(Diagnosis.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<Diagnosis> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Diagnosis.class);
        criteriaQuery.from(Diagnosis.class);
        List<Diagnosis> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return list;
    }
}
