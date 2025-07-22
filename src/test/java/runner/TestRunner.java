package runner;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.Collections;

public class TestRunner {


    public static void main(String[] args) {

        TestNG testng = new TestNG();
        testng.setTestSuites(Collections.singletonList("C:\\Users\\Admin\\IdeaProjects\\Api_Automation\\src\\test\\resources\\testng.xml")); // Path to your TestNG XML
        testng.run();

    }
}
