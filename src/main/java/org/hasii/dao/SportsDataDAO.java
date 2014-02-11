package org.hasii.dao;

import org.hasii.model.SportsData;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Humberto A. Sanchez II
 *
 */
@Repository
public class SportsDataDAO extends BaseDAO<SportsData> {

    public  static  final   String  BY_ID_HQL = "from SportsData where id = ";
    public  static  final   String  ALL_HQL   = "from SportsData";
    /**
     * 
     */
    public SportsDataDAO() {

        setByIDHQL(BY_ID_HQL);
        setAllHQL(ALL_HQL);
    }
}
