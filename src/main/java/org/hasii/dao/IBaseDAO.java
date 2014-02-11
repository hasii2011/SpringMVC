package org.hasii.dao;

import java.util.List;

public interface IBaseDAO <T>{

    public T getById(String theId);
    List<T> getAll();
    public void saveOrUpdate(T  theObject);

    //
    // Questionable whether these should be part of this interface or a 
    // separate one;  Start with them here now
    //
    String getAllHQL();
    void setAllHQL(String theAllHQL);
    /**
     * Set the by ID HQL;  Ensure that the named parameter is 'id'
     * @return
     */
    String getByIDHQL();
    void setByIDHQL(String theByIDHQL);
}