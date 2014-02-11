package org.hasii.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.hasii.model.SportsData;
import org.hasii.service.SportsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@RequestMapping("/sportsdata")
@Controller("sportsDataController")
/**
 * This is really the RunSummaryDataController
 * 
 * 
 * @author Humberto A. Sanchez II
 *
 */
public class SportsDataController {

    private static Logger logger = Logger.getLogger(SportsDataController.class);

    @Autowired
    private SportsDataService   _sdService;

    public SportsDataController() {

    }
    @RequestMapping(value="/load/{id}",  method= RequestMethod.GET, produces="application/json")
    public @ResponseBody SportsData getData(@PathVariable String id) {

        logger.debug("Requesting data point: " + id);
        SportsData sd = _sdService.getById(id);
        logger.info("Returning record: " + sd.toString());
        return sd;
    }
    @RequestMapping(value="/getAll", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<SportsData> getAllRunSummaries() {
        List<SportsData> summaries = _sdService.getAll();
        return summaries;
    }
}