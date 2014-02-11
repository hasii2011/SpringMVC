package org.hasii.dao;

import org.hasii.model.RunSummary;


import org.springframework.stereotype.Repository;

/**
 * 
 * @author Humberto A. Sanchez II
 *
 */
@Repository
public class RunSummaryDAO extends BaseDAO<RunSummary> {

    public  static  final   String  BY_ID_HQL = "from RunSummary where id = ";
    public  static  final   String  ALL_HQL   = "from RunSummary";
    /**
     * I wonder if these should be injected !
     * 
     */
    public RunSummaryDAO() {

        setAllHQL(ALL_HQL);
        setByIDHQL(BY_ID_HQL);
    }
}
