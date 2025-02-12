package practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class scriptexe {
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName('q')[0].value = 'mobile';");
		
		
		
	}

}
