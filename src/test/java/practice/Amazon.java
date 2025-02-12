package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=iphone+15+128gb&crid=3CKVHNXLPUJYI&sprefix=iphoned%2Caps%2C223&ref=nb_sb_ss_ts-doa-p_1_7");
		driver.manage().window().maximize();
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arugument[0].scrollIntoView(320,0)");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File desi = new File("path");
		FileUtils.copyFile(source,desi);
		
	}

}
