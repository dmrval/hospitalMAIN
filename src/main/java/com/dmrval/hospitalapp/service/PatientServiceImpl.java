package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.PatientDao;
import com.dmrval.hospitalapp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDao patientDao;

    @Override
    public List<Patient> getAllPatient() {
        return patientDao.getAllPatient();
    }

    @Override
    public void addPatient(Patient patient) {
        patientDao.addPatient(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDao.updatePatient(patient);
    }

    @Override
    public void removePatient(int id) {
        patientDao.removePatient(id);
    }

    @Override
    public Patient getPatient(int id) {
        return patientDao.getPatient(id);
    }

    @Override
    public Patient getPatientbyLogin(String login) {
        return patientDao.getPatientbyLogin(login);
    }


}
