package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.entity.Doctor;

import java.util.List;

public interface DoctorServise {
    List<Doctor> getAllDoctor();
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void removeDoctor(int id);
    Doctor getDoctor(int id);
}
