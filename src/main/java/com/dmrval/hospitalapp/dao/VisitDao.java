package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Visit;

import java.util.List;

public interface VisitDao {
    List<Visit> getAllVisit();
    void addVisit(Visit visit);
    void updateVisit(Visit visit);
    void removeVisit(int id);
    Visit getVisit(int id);
}
