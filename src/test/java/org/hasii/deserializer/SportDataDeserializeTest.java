package org.hasii.deserializer;

import java.io.File;

import org.apache.log4j.Logger;
import org.hasii.Utility;
import org.hasii.model.SportsData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SportDataDeserializeTest {

    static  final   Logger  logger              = Logger.getLogger(SportDataDeserializeTest.class);

    @BeforeClass
    public static void testSetup() {
        Utility.setupDebugLogging();
    }
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDeserializer() {

        Serializer serializer = new Persister();
        File       source     = new File("workouts/2010-12-01 08;13;52.xml");

        try {
            SportsData sd        = serializer.read(SportsData.class,source);

            logger.debug(sd.toString());
        } catch (Exception e) {

            e.printStackTrace();
            Assert.assertTrue(false);
        }

    }

}
