package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Doctor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
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
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Doctor where doctorid=" + id);
        query.executeUpdate();
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

    @Override
    public Doctor getDoctorbyLogin(String log) {
        sessionFactory.getCurrentSession().beginTransaction();
        List<Doctor> listPat = getAllDoctorPrivate();
        Doctor result = new Doctor();
        for (Doctor ds:listPat
        ) {
            if (ds.getUser().getLogin().equals(log)) {
                result = ds;
            }
        }
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return result;
    }

    //PRIVATE only this class use=))
    private Doctor getDoctorPrivate(int id) {
        Doctor temp = sessionFactory.getCurrentSession().get(Doctor.class, id);
        return temp;
    }

    private List<Doctor> getAllDoctorPrivate() {
        CriteriaQuery<Doctor> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Doctor.class);
        criteriaQuery.from(Doctor.class);
        List<Doctor> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return list;
    }


}
