package org.hasii;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
/**
 * Static singleton class
 * 
 * @author Humberto A. Sanchez II
 *
 */
public final class Utility {

    private Utility() {
    }
    public static void setupDebugLogging() {

        Properties  logProperties = new Properties();
        ClassLoader cLoader       = Thread.currentThread().getContextClassLoader();
        InputStream inStream      = cLoader.getResourceAsStream(Constants.LOG_PROPERTIES_FILE);

        try {

          logProperties.load(inStream);
        }
        catch(IOException e) {
          throw new RuntimeException("Unable to load logging property " + Constants.LOG_PROPERTIES_FILE);
        }
        System.err.println(logProperties.toString());
        PropertyConfigurator.configure(logProperties);
    }
}
