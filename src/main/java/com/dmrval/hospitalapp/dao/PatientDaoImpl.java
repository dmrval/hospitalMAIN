package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Patient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class PatientDaoImpl implements PatientDao {
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
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Patient where patientid=" + id);
        query.executeUpdate();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    public Patient getPatient(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Patient temp = null;
        List<Patient> list = getAllPatientPrivate();
        for (Patient pt : list) {
            if (pt.getPatientid() == id) {
                temp = pt;
            }
        }
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }

    @Override
    public Patient getPatientbyLogin(String log) {
        sessionFactory.getCurrentSession().beginTransaction();
        List<Patient> listPat = getAllPatientPrivate();
        Patient result = new Patient();
        for (Patient ds:listPat
             ) {
            if (ds.getUser().getLogin().equals(log)) {
                result = ds;
            }
        }
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return result;
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

    // PRIVATE only this class use=))
    private Patient getPatientPrivate(int id) {
        return sessionFactory.getCurrentSession().get(Patient.class, id);
    }

    private List<Patient> getAllPatientPrivate() {
        CriteriaQuery<Patient> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Patient.class);
        criteriaQuery.from(Patient.class);
        List<Patient> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return list;
    }


}
