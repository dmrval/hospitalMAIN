package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional
    public User findByLogin(String login) {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<User> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        List<User> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        for (User u : list) {
            if (u.getLogin().equals(login)) {
                User s = getUserPrivate(u.getUserid());
                sessionFactory.getCurrentSession().getTransaction().commit();
                sessionFactory.getCurrentSession().close();
                return s;
            }
        }
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return null;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        sessionFactory.getCurrentSession().beginTransaction();
        CriteriaQuery<User> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        List<User> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return list;
    }

    @Override
    @Transactional
    public User getUser(int id) {
        sessionFactory.getCurrentSession().beginTransaction();
        User temp = sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
        return temp;
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().beginTransaction();
        Serializable result = sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().update(user);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    //PRIVATE only this class use=))
    private User getUserPrivate(int id) {
        User temp = sessionFactory.getCurrentSession().get(User.class, id);
        return temp;
    }

    
}
