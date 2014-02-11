package org.hasii.service;

import java.util.List;


public interface BaseService<M> {

    public M getById(String theId);
    public List<M> getAll();
    public void saveOrUpdate(M theModelObject);

}