package tests;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;

@RunWith(JUnitPlatform.class)
@SelectClasses({BargeTest.class , CaravelTest.class,CarrackTest.class, FleetTest.class,FrigateTest.class,GalleonTest.class})
public class AllTests {

}
