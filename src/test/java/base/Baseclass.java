package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	
		public static WebDriver driver;
		
		public static void geturl(String url) {
			driver.get(url);
		}
		
		public static void maximum() {
			driver.manage().window().maximize();
		}
		
		public static void implicitwait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
		
		public static void feature(WebElement web) {
			web.click();
		}
		
		public static void jsClick(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
		}
		
		public static void jsScroll(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollintoview();", element);
		}
		
		public static void explicitwait(WebElement locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		
	    public static void screenshot(WebDriver driver,String imageName) throws IOException {
	        TakesScreenshot screenshot = (TakesScreenshot)driver;
	        File imgType = screenshot.getScreenshotAs(OutputType.FILE);
	        File imgPath = new File("C:\\Users\\Revanth\\eclipse-workspace\\Testing_DominusWebsite\\Dominus Screenshot\\"+imageName+".png");
	        FileUtils.copyFile(imgType, imgPath);
	     }

	     public static void scrollup(WebDriver driver,WebElement web) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(false)",web);
	     }
	     
	     public static void toHold( WebDriver driver,int seconds){
	        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(seconds));
	     }

	     public void windowhandle(WebDriver driver,String windowTitle) {
	             for (String windowHandle : driver.getWindowHandles()) {
	                 driver.switchTo().window(windowHandle);
	                 if (driver.getTitle().equals(windowTitle)) {
	                     break;
	                 }
	             }
	         }
	      
	     public void windowhandleparent(WebDriver driver ) {
	         Set<String> opcw = driver.getWindowHandles();
	         Iterator<String> itera = opcw.iterator();
	         String parent = itera.next();
	         String child = itera.next();
	         driver.switchTo().window(parent);
	      }
	     
	     public static void NavigateBack() {
	        driver.navigate().back();
	     }
	     public static void log(String text) {
	        System.out.println(text);
	     }
	     public static void quit() {
	        driver.quit();
	     }
	 }

	
