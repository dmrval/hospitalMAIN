package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.entity.Medicalpolicy;

import java.util.List;

public interface MedicalpolicyServise {
    List<Medicalpolicy> getAllMedicalpolicy();
    void addMedicalpolicy(Medicalpolicy medicalpolicy);
    void updateMedicalpolicy(Medicalpolicy medicalpolicy);
    void removeMedicalpolicy(int id);
    Medicalpolicy getMedicalpolicy(int id);
}
