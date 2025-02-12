package product;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src\\test\\resources\\features\\flip.feature", name = "Search product", plugin = {"html: flipkart.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
