package org.hasii;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.hasii.deserializer.SportDataDeserializeTest;
import org.hasii.deserializer.WalkAllFilesTest;
import org.hasii.service.SportsDataServiceTest;

@RunWith(Suite.class)
@SuiteClasses(
              { SportDataDeserializeTest.class,
                WalkAllFilesTest.class,
                SportsDataServiceTest.class
              }
             )
//@SuiteClasses(
//        { 
//          SportsDataServiceTest.class
//        }
//       )

public class AllTestSuite {

}