package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.MedicalpolicyDao;
import com.dmrval.hospitalapp.entity.Medicalpolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicalpolicyServiseImpl implements MedicalpolicyServise{
    @Autowired
    MedicalpolicyDao MedicalpolicyDao;

    @Override
    public List<Medicalpolicy> getAllMedicalpolicy() {
        return MedicalpolicyDao.getAllMedicalpolicy();
    }

    @Override
    public void addMedicalpolicy(Medicalpolicy medicalpolicy) {
        MedicalpolicyDao.addMedicalpolicy(medicalpolicy);
    }

    @Override
    public void updateMedicalpolicy(Medicalpolicy medicalpolicy) {
        MedicalpolicyDao.updateMedicalpolicy(medicalpolicy);
    }

    @Override
    public void removeMedicalpolicy(int id) {
        MedicalpolicyDao.removeMedicalpolicy(id);
    }

    @Override
    public Medicalpolicy getMedicalpolicy(int id) {
        return MedicalpolicyDao.getMedicalpolicy(id);
    }

    
}
