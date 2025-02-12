package product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

   public static WebDriver driver;
	
    @Parameters({"Browser"})
    @BeforeTest            //@optional="chrome", string browser  
	public void openbrowser(String Browser) {
    	switch(Browser) {
    	case "chrome":
    		driver = new ChromeDriver();
    		break;
    	case "edge":
    		driver = new EdgeDriver();
    		break;	
    	}
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	}
    
    
	@Test(priority = 1)
	public void search() throws InterruptedException {
	WebElement search = driver.findElement(By.name("q"));
	search.sendKeys("mobiles");
	search.submit();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='XqNaEv'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='XqNaEv'])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='XqNaEv'])[3]")).click();
	Thread.sleep(2000);
	String currentwin = driver.getWindowHandle();
	System.out.println("current : " + currentwin);// it will return current wind
	}
	
	@Test(priority = 2)
	public void addprod_1() throws InterruptedException {
	driver.findElement(By.xpath("//*[contains(text(),'Apple iPhone 15 (Black, 128 GB)')]")).click();
	Thread.sleep(2000);
	switchtonew();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
	Thread.sleep(2000);
	driver.close();
	Thread.sleep(2000);
	switchtomain();
	Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void addprod_2() throws InterruptedException {
	driver.findElement(By.xpath("//*[contains(text(),'Apple iPhone 15 (Pink, 128 GB)')]")).click();
	Thread.sleep(2000);
	switchtonew();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
	Thread.sleep(2000);
	driver.close();
	Thread.sleep(2000);
	switchtomain();
	Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void addprod_3() throws InterruptedException {
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(text(),'SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)')]")).click();
	Thread.sleep(2000);
	switchtonew();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
	Thread.sleep(2000);
	driver.close();
	switchtomain();
	Thread.sleep(2000);
	}
	
	@Test(priority = 5)
    public void cart() throws InterruptedException {
	driver.findElement(By.xpath("//a[@class='_9Wy27C']")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Login")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("8056392559");
	Thread.sleep(2000);
}
    
	
	public void switchtonew() throws InterruptedException {
		Set<String> newwin = driver.getWindowHandles();
		System.out.println("new : " +newwin);
		List<String> win = new ArrayList<String>(newwin);
		driver.switchTo().window(win.get(1));
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		
	}
	
	public void switchtomain() throws InterruptedException {
		Set<String> mainwin = driver.getWindowHandles();
		System.out.println("new : "+ mainwin );
		List<String> win1 = new ArrayList<String>(mainwin);
		driver.switchTo().window(win1.get(0));
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
	}
	
	@AfterTest
    public void closebrowser() throws InterruptedException {
    	driver.quit();
    	Thread.sleep(2000);
    }
    


}
