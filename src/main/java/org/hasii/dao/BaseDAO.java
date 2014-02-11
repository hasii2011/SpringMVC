package org.hasii.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * TODO Fix this so the specific schema to get from is passed in.
 * For my use I only really care to get RunSummaries
 * 
 * @author Humberto A. Sanchez II
 *
 * @param <T>
 */
@Repository
public class BaseDAO<T> implements IBaseDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    private String         byIDHQL;
    private String         allHQL;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public String getByIDHQL() {
        return byIDHQL;
    }

    public void setByIDHQL(final String theByIDHQL) {
        this.byIDHQL = theByIDHQL;
    }
    public String getAllHQL() {
        return allHQL;
    }
    public void setAllHQL(final String theAllHQL) {
        this.allHQL = theAllHQL;
    }
    
    @SuppressWarnings("unchecked")
    public T getById(String theId) {

        T obj;
        assert byIDHQL != null;
        Session session = sessionFactory.getCurrentSession();
        Query   q       = session.createQuery(byIDHQL + theId);

        obj = (T) q.uniqueResult();
        return obj;
    }
    public List<T> getAll() {

        assert allHQL != null;
        Session session = sessionFactory.getCurrentSession();
        Query   q       = session.createQuery(allHQL);

        @SuppressWarnings("unchecked")
        List<T> rsList = q.list(); 

        return rsList;
    }
    public void saveOrUpdate(T  theObject) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(theObject);
    }

}