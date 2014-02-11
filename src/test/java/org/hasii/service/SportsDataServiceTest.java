package org.hasii.service;


import org.apache.log4j.Logger;
import org.hasii.Utility;
import org.hasii.deserializer.SportDataDeserializeTest;
import org.hasii.model.SportsData;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SportsDataServiceTest {

    static  final   Logger  logger              = Logger.getLogger(SportDataDeserializeTest.class);

    ApplicationContext _Ctx;
    @BeforeClass
    public static void testSetup() {

        Utility.setupDebugLogging();
    }

    @Before
    public void setUp() throws Exception {

        _Ctx = new ClassPathXmlApplicationContext("spring_unit_test.xml");

    }

    @Test
    public void testGetById() {

        SportsDataService aService = (SportsDataService) _Ctx.getBean("sportsDataServiceImpl");

        try {
            SportsData sd = aService.getById("1");

            assertNotNull(sd);
            assertTrue("Only version I understand", "9".equals(sd.getVers()));
            assertTrue("Only type I understand", "pedometer".equals(sd.getType()));
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
    }
}