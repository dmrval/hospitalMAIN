package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Patient;

import java.util.List;

public interface PatientDao {
    List<Patient> getAllPatient();
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    void removePatient(int id);
    Patient getPatient(int id);
}
