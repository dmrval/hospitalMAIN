package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Medicalpolicy;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class MedicalpolicyDaoImpl implements MedicalpolicyDao {
    @Autowired
    SessionFactory sessionFactory;


    public MedicalpolicyDaoImpl() {
    }

    @Override
    @Transactional
    public void addMedicalpolicy(Medicalpolicy license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void updateMedicalpolicy(Medicalpolicy license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void removeMedicalpolicy(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(getMedicalpolicy(id));
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public Medicalpolicy getMedicalpolicy(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Medicalpolicy temp = sessionFactory.getCurrentSession().get(Medicalpolicy.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }

    @Override
    public List<Medicalpolicy> getAllMedicalpolicy() {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<Medicalpolicy> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Medicalpolicy.class);
        criteriaQuery.from(Medicalpolicy.class);
        List<Medicalpolicy> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return list;
    }
}
