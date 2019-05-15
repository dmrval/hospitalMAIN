package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.DoctorlicenseDao;
import com.dmrval.hospitalapp.entity.Doctorlicense;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class DoctorlicenseServiseImpl implements DoctorlicenseServise {

    @Autowired
    DoctorlicenseDao doctorlicenseDao;

    @Override
    public List<Doctorlicense> getAllDoctorlicense() {
        return doctorlicenseDao.getAllDoctorlicense();
    }

    @Override
    public Serializable addDoctorlicense(Doctorlicense license) {
        return doctorlicenseDao.addDoctorlicense(license);
    }

    @Override
    public void updateDoctorlicense(Doctorlicense license) {
        doctorlicenseDao.updateDoctorlicense(license);
    }

    @Override
    public void removeDoctorlicense(int id) {
        doctorlicenseDao.removeDoctorlicense(id);
    }

    @Override
    public Doctorlicense getDoctorlicense(int id) {
        return doctorlicenseDao.getDoctorlicense(id);
    }
}
