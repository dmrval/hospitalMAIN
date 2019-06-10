package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Doctor;
import com.dmrval.hospitalapp.entity.Patient;

import java.util.List;

public interface DoctorDao {
    List<Doctor> getAllDoctor();
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void removeDoctor(int id);
    Doctor getDoctor(int id);
    Doctor getDoctorbyLogin(String log);

}
