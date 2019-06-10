package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.VisitDao;
import com.dmrval.hospitalapp.entity.Doctor;
import com.dmrval.hospitalapp.entity.Patient;
import com.dmrval.hospitalapp.entity.Visit;
import com.dmrval.hospitalapp.entity.WorkCalendar;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

public class VisitServiceImpl implements VisitService {
    @Autowired
    VisitDao visitDao;

    @Override
    public List<Visit> getAllVisit() {
        return visitDao.getAllVisit();
    }

    @Override
    public void addVisit(Visit visit) {
        visitDao.addVisit(visit);
    }

    @Override
    public void updateVisit(Visit visit) {
        visitDao.updateVisit(visit);
    }

    @Override
    public void removeVisit(int id) {
        visitDao.removeVisit(id);
    }

    @Override
    public Visit getVisit(int id) {
        return visitDao.getVisit(id);
    }


    public List<Visit> sortByTime() {
        List<Visit> list = getAllVisit();
        list.sort((e1, e2) ->
                new Long(e1.getDayofvisit().getTime()).compareTo(
                        new Long(e2.getDayofvisit().getTime())));
        return list;
    }

    @Override
    public List<Visit> getAllVisit_ByOnePatient(Patient patient) {
        return visitDao.getAllVisit_ByOnePatient(patient);
    }

    @Override
    public List<Timestamp> getTimestampByDoctor(Doctor doctor) {
        return visitDao.getTimestampByDoctor(doctor);
    }

    @Override
    public WorkCalendar getWorkCalendar() {
        return visitDao.getWorkCalendar();
    }


}
