package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Doctorlicense;

import java.io.Serializable;
import java.util.List;

public interface DoctorlicenseDao {
    List<Doctorlicense> getAllDoctorlicense();
    Serializable addDoctorlicense(Doctorlicense license);
    void updateDoctorlicense(Doctorlicense license);
    void removeDoctorlicense(int id);
    Doctorlicense getDoctorlicense(int id);
}
