package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Diagnosis;

import java.util.List;

public interface DiagnosisDao {
    List<Diagnosis> getAllDiagnosis();
    Diagnosis addDiagnosis(Diagnosis diagnosis);
    void updateDiagnosis(Diagnosis diagnosis);
    void removeDiagnosis(int id);
    Diagnosis getDiagnosis(int id);
}
