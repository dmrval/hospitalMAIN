package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Doctor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    SessionFactory sessionFactory;


    public DoctorDaoImpl() {
    }

    @Override
    @Transactional
    public void addDoctor(Doctor license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void updateDoctor(Doctor license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void removeDoctor(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(getDoctor(id));
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public Doctor getDoctor(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Doctor temp = sessionFactory.getCurrentSession().get(Doctor.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }

    @Override
    public List<Doctor> getAllDoctor() {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<Doctor> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Doctor.class);
        criteriaQuery.from(Doctor.class);
        List<Doctor> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return list;
    }
}
