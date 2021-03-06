package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Doctor;
import com.dmrval.hospitalapp.entity.Patient;
import com.dmrval.hospitalapp.entity.Visit;
import com.dmrval.hospitalapp.entity.WorkCalendar;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public interface VisitDao {
    List<Visit> getAllVisit();

    void addVisit(Visit visit);

    void updateVisit(Visit visit);

    void removeVisit(int id);

    Visit getVisit(int id);

    List<Visit> getAllVisit_ByOnePatient(Patient patient);

    List<Visit> getAllVisit_ByOneDoctor(Doctor doctor);

    List<Timestamp> getTimestampByDoctor(Doctor doctor);

    WorkCalendar getWorkCalendar();



}
