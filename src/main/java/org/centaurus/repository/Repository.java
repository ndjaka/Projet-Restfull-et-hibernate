package org.centaurus.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

@Component
public class Repository<T, U> implements IRepository<T, U> {

    private static SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(Repository.class);
    private Class<T> type;


    public Repository() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public T save(T obj) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            logger.info("............succes de l'operation ...........");

        } catch (Exception e) {
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
                logger.info("............erreur avortement de la transaction...........");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return obj;
    }

    @Override
    public T findById(U id) {
        Session session = sessionFactory.openSession();
        T t = null;
        try {
            session.beginTransaction();
            t = (T) session.load(type.getTypeName(), (Serializable) id);
            logger.info("le produit est " + t.toString());
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                logger.info("le produit n'existe pas ");
                session.getTransaction().rollback();
            }
            return t;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Collection<T> getAll() {
        Session session = sessionFactory.openSession();
        List<T> tList;
        Criteria criteria = session.createCriteria(type.getTypeName());
        tList = (List<T>) criteria.list();
        logger.info(".............la liste est " + tList.toString());
        return tList;
    }

    @Override
    public void delete(U id) {
        Session session = sessionFactory.openSession();
        T t;
        try {
            session.beginTransaction();
            t = (T) session.get(type.getTypeName(), (Serializable) id);
            session.delete(t);
            session.getTransaction().commit();
            logger.info(".............le produit n " + id + " a bien ete supprimer.................. ");

        } catch (Exception e) {
            e.printStackTrace();
            if (null != session.getTransaction()) {
                logger.info(".............avortement de la transaction");
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) session.close();

        }
    }

    @Override
    public T update(T t) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            logger.info("............succes de l'operation ...........");

        } catch (Exception e) {
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
                logger.info("............erreur avortement de la transaction...........");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return t;
    }
}
