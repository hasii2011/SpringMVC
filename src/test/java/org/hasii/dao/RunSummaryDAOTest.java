package org.hasii.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hasii.Utility;
import org.hasii.model.RunSummary;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
/**
 * 
 * 
 * @author Humberto A. Sanchez II
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = "classpath:spring_unit_test.xml" )
public class RunSummaryDAOTest {

    private static Logger LOGGER = Logger.getLogger(RunSummaryDAOTest.class);

    private static  final   Integer  FIRST_RECORD = 1;
    @Autowired
    private RunSummaryDAO   dao;
    
    @BeforeClass
    public static void testSetup() {
        Utility.setupDebugLogging();
    }
    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Transactional
    public void testAll() {

        List<RunSummary> recs = dao.getAll();

        assertTrue("There should be at least a single run summary in the DB", recs.size() != 0);
    }


    @Test
    @Transactional
    public void testById() {

        RunSummary  r = dao.getById("1");

        assertNotNull("There should be at least a single run summary in the DB", r);

        Integer id = r.getId();
        assertTrue("Not the one I asked for", FIRST_RECORD.equals(id));
        LOGGER.info("r.id: " + id);
    }

}
