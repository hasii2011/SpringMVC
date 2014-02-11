package org.hasii.service;

import java.util.List;

import org.hasii.dao.RunSummaryDAO;
import org.hasii.model.RunSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// extends BaseServiceImpl<RunSummary> 
@Service
@Transactional
public class RunSummaryServiceImpl implements RunSummaryService {

    @Autowired
    private RunSummaryDAO runSummaryDao;
 
    public List<RunSummary> getAll() {
        return runSummaryDao.getAll();
    }
 
    public void saveOrUpdate(RunSummary theRunSummary) {
        runSummaryDao.saveOrUpdate(theRunSummary);
    }
}