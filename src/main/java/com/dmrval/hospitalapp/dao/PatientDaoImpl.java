package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Patient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class PatientDaoImpl implements PatientDao{
    @Autowired
    SessionFactory sessionFactory;


    public PatientDaoImpl() {
    }

    @Override
    @Transactional
    public void addPatient(Patient license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void updatePatient(Patient license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void removePatient(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(getPatient(id));
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public Patient getPatient(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Patient temp = sessionFactory.getCurrentSession().get(Patient.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }

    @Override
    public List<Patient> getAllPatient() {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<Patient> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Patient.class);
        criteriaQuery.from(Patient.class);
        List<Patient> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return list;
    }
}
