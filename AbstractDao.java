package com.inventorysystem.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public boolean deleteById(Class<?> type, Serializable id) {
        Object persistentInstance = getSession().load(type, id);
        if (persistentInstance != null) {
            getSession().delete(persistentInstance);
            return true;
        }
        return false;
    }
}