package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Doctor;
import com.dmrval.hospitalapp.entity.Patient;
import com.dmrval.hospitalapp.entity.Visit;
import com.dmrval.hospitalapp.entity.WorkCalendar;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VisitDaoImpl implements VisitDao{
    @Autowired
    private SessionFactory sessionFactory;

    private WorkCalendar workCalendar;

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
    public List<Visit> getAllVisit_ByOnePatient(Patient patient) {
        List<Visit> allVisits = getAllVisit();
        List<Visit> patientVisits = new ArrayList<>();
        for (Visit v : allVisits
        ) {
            if (v.getPatient().getUser().getLogin().equals(patient.getUser().getLogin())) {
                patientVisits.add(v);
            }
        }

        return patientVisits;
    }

    @Override
    public List<Visit> getAllVisit_ByOneDoctor(Doctor doctor) {
        List<Visit> allVisits = getAllVisit();
        List<Visit> doctorVisits = new ArrayList<>();
        for (Visit v : allVisits
        ) {
            if (v.getDoctor().getUser().getLogin().equals(doctor.getUser().getLogin())) {
                doctorVisits.add(v);
            }
        }

        return doctorVisits;
    }

    @Override
    public List<Timestamp> getTimestampByDoctor(Doctor doctor) {
        List<Visit> allVisits = getAllVisit();
        List<Visit> doctorVisits = new ArrayList<>();
        for (Visit curr : allVisits) {
            if (curr.getDoctor().getUser().getLogin().equals(doctor.getUser().getLogin())) {
                doctorVisits.add(curr);
            }
        }
        List<Timestamp> workCal = new WorkCalendar().getWorkCalendar();
        for (Visit curr : doctorVisits) {
            for (int i = 0; i < workCal.size(); i++) {
                if (curr.getDayofvisit().compareTo(workCal.get(i)) == 0) {
                    workCal.remove(i);
                }
            }
        }
        workCalendar = new WorkCalendar(workCal);
        return workCal;
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

    public WorkCalendar getWorkCalendar() {
        return workCalendar;
    }


}
