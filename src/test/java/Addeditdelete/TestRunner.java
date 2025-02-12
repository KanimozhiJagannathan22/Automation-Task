package Addeditdelete;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\features\\orange.feature",name = "Datadriven", plugin = {"html:report.html"},dryRun = true)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
