package product;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition{
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("open browser")
	public void open_browser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/"); 
		wait= new WebDriverWait(driver, Duration.ofSeconds(10)); 
	}

	@When("search")
	public void search() throws InterruptedException {
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		search.sendKeys("mobiles");
		search.submit();
		driver.findElement(By.xpath("(//div[@class='XqNaEv'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='XqNaEv'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='XqNaEv'])[3]")).click();
		Thread.sleep(1000);
		String currentwin = driver.getWindowHandle();
		System.out.println("current url : " + currentwin);
	}
	
	public void switch_to_new() throws InterruptedException {
		Set<String> newwin = driver.getWindowHandles();
//		System.out.println("new : " +newwin);
		List<String> win = new ArrayList<String>(newwin);
		driver.switchTo().window(win.get(1));
	}

	public void switch_to_main() throws InterruptedException {
		Set<String> mainwin = driver.getWindowHandles();
//		System.out.println("new : " + mainwin);3
		List<String> win1 = new ArrayList<String>(mainwin);
		driver.switchTo().window(win1.get(0));
	}

	@When("add product one")
	public void add_product_one() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(text(),'Apple iPhone 15 (Black, 128 GB)')]")).click();
		Thread.sleep(2000);
		switch_to_new();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		switch_to_main();
		Thread.sleep(2000);	   
	}

	@When("add product two")
	public void add_product_two() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(text(),'Apple iPhone 15 (Pink, 128 GB)')]")).click();
		Thread.sleep(2000);
		switch_to_new();
		Thread.sleep(2000);
		WebElement rate2 = driver.findElement(By.xpath("//*[contains(text(),'₹58,999')]"));
		System.out.println(rate2.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		Thread.sleep(2000);
		driver.close();
		switch_to_main();
		Thread.sleep(2000);
	}

	@When("add product three")
	public void add_product_three() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)')]")).click();
		Thread.sleep(2000);
		switch_to_new();
		Thread.sleep(2000);
		WebElement rate3 = driver.findElement(By.xpath("//*[contains(text(),'₹6,499')]"));
		System.out.println(rate3.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		Thread.sleep(2000);
		driver.close();
		switch_to_main();
		Thread.sleep(2000);  
	}
	
	@When("go to cart")
	public void go_to_cart() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='_9Wy27C']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("8056392559");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']")).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement otpfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='XDRRi5']")));
		Thread.sleep(2000);
		driver.findElement(By.linkText("Verify")).click();
		Thread.sleep(5000);		
	}

	@When("Buynow")
	public void buynow() {
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='LAlF6k re6bBo']"));
		
		int min = Integer.MAX_VALUE;
		int index = -1;
		
		for(int i = 0; i<price.size();i++) {
			String symbol = price.get(i).getText().replaceAll("₹,","");	
			int cost = Integer.parseInt(symbol);
			
			 if (cost < min) {
                 min = cost;
                 index = i;
             }}}

	@When("close the browser")
	public void close_the_browser() throws InterruptedException {
		if (driver != null) {
	        driver.quit();
	    }
    	Thread.sleep(2000);   
	}

}
