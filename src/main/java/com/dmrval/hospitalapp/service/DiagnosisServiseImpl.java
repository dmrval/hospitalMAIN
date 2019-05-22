package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.DiagnosisDao;
import com.dmrval.hospitalapp.entity.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DiagnosisServiseImpl implements DiagnosisServise {

    @Autowired
    DiagnosisDao DiagnosisDao;

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        return DiagnosisDao.getAllDiagnosis();
    }

    @Override
    public Diagnosis addDiagnosis(Diagnosis diagnosis) {

        return DiagnosisDao.addDiagnosis(diagnosis);
    }

    @Override
    public void updateDiagnosis(Diagnosis diagnosis) {
        DiagnosisDao.updateDiagnosis(diagnosis);
    }

    @Override
    public void removeDiagnosis(int id) {
        DiagnosisDao.removeDiagnosis(id);
    }

    @Override
    public Diagnosis getDiagnosis(int id) {
        return DiagnosisDao.getDiagnosis(id);
    }
}
