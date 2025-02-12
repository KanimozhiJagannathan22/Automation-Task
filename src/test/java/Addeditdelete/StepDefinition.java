package Addeditdelete;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
	private WebDriver driver = null;
	
	@Given("open browser and enter url")
	public void open_browser_and_enter_url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   
	}
	@When("enter username, password and click on login")
	public void enter_username_password_and_click_on_login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin"); 
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	    
	}
	
	@When("enter {string},{string} and click on login")
	public void enter_and_click_on_login(String string, String string2) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(string); 
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys(string2);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	    
	}
	
	@When("click on logout")
	public void click_on_logout() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
	   
	}
	@When("close browser")
	public void close_browser() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	    
	}

	
	

}
