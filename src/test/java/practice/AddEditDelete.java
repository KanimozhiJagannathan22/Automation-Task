package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AddEditDelete {
	
	WebDriver driver = null;
	
	@Parameters({"browser"})
	@BeforeTest 
	                        //default browser
	public void openbrowser(@Optional("Chrome") String browser) {
		
//		String browser = "chrome";
		
		switch(browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	
    @BeforeMethod
	public void login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin"); 
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
	}
	
	@Test(invocationCount = 1, priority = 0, groups = {"Smoke", "Regression"})
	public void add() throws InterruptedException {
		
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys("kani");
		Thread.sleep(2000);
		driver.findElement(By.name("lastName")).sendKeys("mozhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
	}
	
	
	@Test(enabled = true, groups = {"Smoke"})
	public void edit() throws InterruptedException {
		
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("kani");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]")).sendKeys("1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		Thread.sleep(2000);
		
		
	}
	
	
	
	@Test(enabled = false)
	public void delete() throws InterruptedException {
		
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("kani");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]")).click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
    	Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
		Thread.sleep(2000);
				
}
	@AfterMethod
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		
	}
	@AfterTest
	public void closebrowser() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
		
	}
	

}
