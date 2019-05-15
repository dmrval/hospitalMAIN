package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.VisitDao;
import com.dmrval.hospitalapp.entity.Visit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VisitServiseImpl implements VisitServise{
    @Autowired
    VisitDao VisitDao;

    @Override
    public List<Visit> getAllVisit() {
        return VisitDao.getAllVisit();
    }

    @Override
    public void addVisit(Visit visit) {
        VisitDao.addVisit(visit);
    }

    @Override
    public void updateVisit(Visit visit) {
        VisitDao.updateVisit(visit);
    }

    @Override
    public void removeVisit(int id) {
        VisitDao.removeVisit(id);
    }

    @Override
    public Visit getVisit(int id) {
        return VisitDao.getVisit(id);
    }


    public List<Visit> sortByTime() {
        List<Visit> list = getAllVisit();
        list.sort((e1, e2) ->
                new Long(e1.getDayofvisit().getTime()).compareTo(
                        new Long(e2.getDayofvisit().getTime())));
        return list;
    }
}
