package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Medicalpolicy;

import java.util.List;

public interface MedicalpolicyDao {
    List<Medicalpolicy> getAllMedicalpolicy();
    void addMedicalpolicy(Medicalpolicy medicalpolicy);
    void updateMedicalpolicy(Medicalpolicy medicalpolicy);
    void removeMedicalpolicy(int id);
    Medicalpolicy getMedicalpolicy(int id);
}
