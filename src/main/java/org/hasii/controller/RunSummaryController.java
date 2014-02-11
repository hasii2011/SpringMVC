package org.hasii.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.hasii.model.RunSummary;
import org.hasii.service.RunSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @author Humberto A. Sanchez II
 *
 */
@RequestMapping("/runsummary")
@Controller("runSummaryController")
public class RunSummaryController {

    private static Logger LOGGER = Logger.getLogger(RunSummaryController.class);

    @Autowired
    private RunSummaryService   service;
    
    @RequestMapping(value="/getAll", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<RunSummary> getAllRunSummaries() {

        List<RunSummary> summaries = service.getAll();

        LOGGER.info("Returning " + summaries.size() + " summaries");
        return summaries;
    }
    @RequestMapping(value="/updateSummary", method = RequestMethod.POST, consumes="application/json")
    public @ResponseBody RunSummary saveOrUpdate(@RequestBody RunSummary rs, BindingResult bResult) {

        if(bResult.hasErrors()) {
            LOGGER.error("Error ::: " + bResult.toString());
        }
        LOGGER.info("Saving or updating: " + rs.getId());
        service.saveOrUpdate(rs);
        return rs;
    }
}
