package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.entity.Patient;

import java.util.List;

public interface PatientServise {
    List<Patient> getAllPatient();

    void addPatient(Patient patient);

    void updatePatient(Patient patient);

    void removePatient(int id);

    Patient getPatient(int id);
}
