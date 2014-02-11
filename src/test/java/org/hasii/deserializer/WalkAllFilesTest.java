package org.hasii.deserializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hasii.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WalkAllFilesTest {

    static  final   Logger  logger              = Logger.getLogger(WalkAllFilesTest.class);

    static  final   String  LOG_PROPERTIES_FILE = "bin/log4j.properties";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        Properties logProperties = new Properties();

        try {
          // load our log4j properties / configuration file
          logProperties.load(new FileInputStream(Constants.LOG_PROPERTIES_FILE));
          PropertyConfigurator.configure(logProperties);
        }
        catch(IOException e) {
          throw new RuntimeException("Unable to load logging property " + LOG_PROPERTIES_FILE);
        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDirectoryLister () {

        File dir = new File(Constants.DATA_FILE_DIRECTORY);
        for (File child : dir.listFiles()) {

            logger.debug(child.getPath());
        }
    }

}
