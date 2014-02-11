package org.hasii.service;


import java.util.List;

import org.hasii.model.RunSummary;


public interface RunSummaryService {
    
    public List<RunSummary> getAll();
    public void saveOrUpdate(RunSummary theRunSummary);
}