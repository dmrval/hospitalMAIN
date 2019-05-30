package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.entity.Visit;

import java.util.List;

public interface VisitService {
    List<Visit> getAllVisit();
    void addVisit(Visit visit);
    void updateVisit(Visit visit);
    void removeVisit(int id);
    Visit getVisit(int id);
    public List<Visit> sortByTime();
}
