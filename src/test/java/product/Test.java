package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.Baseclass;

public class Test extends Baseclass {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		geturl("google.com");
		
		maximum();
		
		implicitwait();
		
		
		
	}

}
