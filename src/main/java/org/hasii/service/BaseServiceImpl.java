package org.hasii.service;

import java.util.List;

import org.hasii.dao.BaseDAO;
import org.hasii.dao.IBaseDAO;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<M> implements BaseService<M> {

    @Autowired
    private BaseDAO<M> dao;
 

    public List<M> getAll() {
        return dao.getAll();
    }

    public void saveOrUpdate(M theModelObject) {
        dao.saveOrUpdate(theModelObject);
    }

    public IBaseDAO<M> getDao() {
        return dao;
    }

    public void setDao(BaseDAO<M> dao) {
        this.dao = dao;
    }

    @Override
    public M getById(String theId) {

        return dao.getById(theId);
    }
}