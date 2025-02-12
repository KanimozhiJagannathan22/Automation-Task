package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectclass {
	
//	
//		@Test
//		public void select() throws InterruptedException {
//		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
//    	Thread.sleep(5000);
//		driver.switchTo().frame("iframeResult");
//		Thread.sleep(2000);
//		WebElement car = driver.findElement(By.id("cars"));
//		Select select = new Select(car);
//		System.out.println(select.getOptions().size());
//		Thread.sleep(2000);
//		select.selectByIndex(1);
//		select.selectByValue("volvo");
//		select.selectByVisibleText("Audi");
//  
//		
		
		
		
		@Test
	public void singleselect() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
		driver.get("https://electoralsearch.eci.gov.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='container-tab-inactive-details']")).click();
		Thread.sleep(2000);
		WebElement state = driver.findElement(By.id("stateID"));
		state.sendKeys("Tamilnadu");
		
//		Select select = new Select(state);
//		System.out.println(select.isMultiple());
//		select.selectByVisibleText("Tamil Nadu");
		
		
		}
		
	

}
