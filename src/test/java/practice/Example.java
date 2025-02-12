package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(2000);
		
		driver.switchTo().frame("iframeResult");
		Thread.sleep(2000);
		
		WebElement multiple = driver.findElement(By.id("cars"));
		multiple.click();
		
		Select s = new Select(multiple);
		s.selectByIndex(1);
		s.selectByValue("volvo");
		s.selectByVisibleText("Audi");
		
	}

}
