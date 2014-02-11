package org.hasii.service;

import java.util.List;

import org.hasii.dao.SportsDataDAO;
import org.hasii.model.SportsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class SportsDataServiceImpl implements SportsDataService {

    @Autowired
    private SportsDataDAO sportsDataDAO;

    
    @Override
    public List<SportsData> getAll() {
        return sportsDataDAO.getAll();
    }

    @Override
    public void saveOrUpdate(SportsData theModelObject) {
        sportsDataDAO.saveOrUpdate(theModelObject);
    }

    @Override
    public SportsData getById(String theId) {

        return sportsDataDAO.getById(theId);
    }
}