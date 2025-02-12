package practice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dropdown");
		driver.manage().window().maximize();
		
		WebElement search =  driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select s = new Select(search);
		s.selectByValue("2");
		
		List<WebElement> options = s.getOptions();
		for(WebElement opt : options ) {
		 System.out.println("Option #"+ opt.getText());
		}
	
		System.out.println(options.size());	
		
		
		
		
		System.out.println(s.getAllSelectedOptions().get(0).getText());
		
		driver.close();
	
	}

}
