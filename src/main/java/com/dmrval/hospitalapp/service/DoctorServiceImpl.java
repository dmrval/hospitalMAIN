package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.DoctorDao;
import com.dmrval.hospitalapp.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorDao DoctorDao;

    @Override
    public List<Doctor> getAllDoctor() {
        return DoctorDao.getAllDoctor();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        DoctorDao.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        DoctorDao.updateDoctor(doctor);
    }

    @Override
    public void removeDoctor(int id) {
        DoctorDao.removeDoctor(id);
    }

    @Override
    public Doctor getDoctor(int id) {
        return DoctorDao.getDoctor(id);
    }
}
