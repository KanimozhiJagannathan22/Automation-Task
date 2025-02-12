package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); 
		   
		  WebDriver driver = new ChromeDriver(); 
		   
		  driver.manage().window().maximize(); 
		   
		  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple"); 
		   
		  driver.switchTo().frame("iframeResult"); 
		 
		  WebElement lstCars  = driver.findElement(By.id("cars")); 
		   
		  Select select = new Select(lstCars); 
		   
		  System.out.println(select.isMultiple()); 
		 
		  select.selectByIndex(0); 
		   
		  Thread.sleep(1000); 
		   
		  select.selectByVisibleText("Opel"); 
		   
		  Thread.sleep(1000); 
		   
		  select.selectByValue("audi"); 
		 
		  Thread.sleep(1000);		
	}

}
