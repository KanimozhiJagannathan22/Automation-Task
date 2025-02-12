package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Move2element {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.dtdc.in/");
		Thread.sleep(2000);
		WebElement m =  driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]"));
		Actions a = new Actions(driver);
		a.moveToElement(m).build().perform();
		
		
	}
	
}
