package org.hasii.investigation.di;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.hasii.Constants;
import org.hasii.Utility;
import org.hasii.model.SportsData;
import org.hasii.service.SportsDataService;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Humberto A. Sanchez II
 *
 */
    public class Main {

        static  final   Logger  logger              = Logger.getLogger(Main.class);

        static  final   int     MAX_RECS_TO_PROCESS = 10;
        /**
         * @param args
         */
        public static void main(String[] args) {

            Utility.setupDebugLogging();
            logger.info("Starting");
            ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

            try {

                File       dir        = new File(Constants.DATA_FILE_DIRECTORY);
                Serializer serializer = new Persister();
                SportsData sd;
                File       source;
                int        recCount   = 0;
                for (File child : dir.listFiles()) {

                    logger.debug(child.getPath());

                    source = new File(child.getPath());
                    sd     = serializer.read(SportsData.class,source);

                    persistRecord(ctx, sd);

                    recCount++;
                    if ( recCount > MAX_RECS_TO_PROCESS ) {
                        break;
                    }
                }

//              SportsData sd = new SportsData();
//              
//              RunSummary rs = new RunSummary();
//              rs.setWorkoutName("Step Workout");
//              rs.setDuration(35978000);
//              rs.setDurationString("9:59'38\"");
//              rs.setCalories(249);
//              rs.setWorkoutTime("2010-12-01T08:13:52+00:00");
//
//              StepCounts sc = new StepCounts();
//              sc.setWalkBegin(0);
//              sc.setWalkEnd(999);
//
//              rs.setStepCounts(sc);
//              sd.setRunSummary(rs);

//              persistRecord(ctx, sd);
            } catch (Exception e) {

                logger.error(e);
            }
            //
            // Now DAO Stuff
            //
    }
    protected static void persistRecord(ApplicationContext theContext, SportsData theRecord) {

        SportsDataService aService = (SportsDataService) theContext.getBean("sportsDataServiceImpl");

        aService.saveOrUpdate(theRecord);

        List<SportsData> rList = aService.getAll();

        logger.debug("# of sport data entries: '" + rList.size() + "'");
    }
}