package practice;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import java.util.List;

		public class Cart {
		    public static void main(String[] args) {
		        // Set up WebDriver
//		        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		        WebDriver driver = new ChromeDriver();
		        
		        try {
		            // Navigate to Flipkart and login
		            driver.get("https://www.flipkart.com");
		            driver.manage().window().maximize();
		            
		            // Close the login pop-up if it appears
		            try {
		                WebElement closeButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
		                closeButton.click();
		            } catch (Exception e) {
		                System.out.println("Login pop-up not found.");
		            }

		            // Navigate to the cart
		            driver.get("https://www.flipkart.com/viewcart");

		            // Locate price elements in the cart
		            List<WebElement> priceElements = driver.findElements(By.cssSelector(".class-containing-price")); // Update selector
		            
		            // Find the lowest price
		            double minPrice = Double.MAX_VALUE;
		            WebElement lowestPriceElement = null;

		            for (WebElement priceElement : priceElements) {
		                String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim();
		                double price = Double.parseDouble(priceText);

		                if (price < minPrice) {
		                    minPrice = price;
		                    lowestPriceElement = priceElement;
		                }
		            }

		            // Print the lowest price and corresponding product
		            if (lowestPriceElement != null) {
		                System.out.println("Lowest Price: ₹" + minPrice);
		                WebElement productElement = lowestPriceElement.findElement(By.xpath("corresponding-product-selector")); // Update selector
		                System.out.println("Product: " + productElement.getText());
		            } else {
		                System.out.println("No products found in the cart.");
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Close the browser
		            driver.quit();
		        }
	}


}
