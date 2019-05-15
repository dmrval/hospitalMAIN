package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.PatientDao;
import com.dmrval.hospitalapp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiseImpl implements PatientServise {
    @Autowired
    PatientDao PatientDao;

    @Override
    public List<Patient> getAllPatient() {
        return PatientDao.getAllPatient();
    }

    @Override
    public void addPatient(Patient patient) {
        PatientDao.addPatient(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        PatientDao.updatePatient(patient);
    }

    @Override
    public void removePatient(int id) {
        PatientDao.removePatient(id);
    }

    @Override
    public Patient getPatient(int id) {
        return PatientDao.getPatient(id);
    }
}
