package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class womenn {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("kani1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Kani@2212");
		driver.findElement(By.id("send2")).click();
		
		Actions a = new Actions(driver);
		WebElement women = driver.findElement(By.id("ui-id-2"));
		a.moveToElement(women).build().perform();
		
		
		
//		driver.findElement(By.linkText("Create an Account")).click();
//		driver.findElement(By.id("firstname")).sendKeys("kani");
//		driver.findElement(By.id("lastname")).sendKeys("mozhi");
//		driver.findElement(By.id("email_address")).sendKeys("kani1@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("Kani@2212");
//		driver.findElement(By.id("password-confirmation")).sendKeys("Kani@2212");
//		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();

	}

}
