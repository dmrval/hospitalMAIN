package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Autowired
    SessionFactory sessionFactory;


    public AddressDaoImpl() {
    }

    @Override
    @Transactional
    public void addAddress(Address license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void updateAddress(Address license) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(license);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public void removeAddress(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(getAddress(id));
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    @Transactional
    public Address getAddress(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        Address temp = sessionFactory.getCurrentSession().get(Address.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }

    @Override
    public List<Address> getAllAddress() {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<Address> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Address.class);
        criteriaQuery.from(Address.class);
        List<Address> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return list;
    }
}
