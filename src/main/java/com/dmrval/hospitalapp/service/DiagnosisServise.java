package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.entity.Diagnosis;

import java.util.List;

public interface DiagnosisServise {
    List<Diagnosis> getAllDiagnosis();

    void addDiagnosis(Diagnosis diagnosis);

    void updateDiagnosis(Diagnosis diagnosis);

    void removeDiagnosis(int id);

    Diagnosis getDiagnosis(int id);
}
