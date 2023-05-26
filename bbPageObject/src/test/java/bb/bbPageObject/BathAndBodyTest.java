package bb.bbPageObject;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	

import java.util.Arrays;
import java.util.List;
	
public class BathAndBodyTest  {


	    public static void main(String[] args) throws InterruptedException {
	        // Set up ChromeDriver using WebDriverManager
	        //WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();

	        // Step 1: Launch website
	        driver.get("https://www.bathandbodyworks.ca/");

	        //INSTANCE CREATED
	        
	        
	        Homepage1 homePage = new Homepage1(driver);
	        
	        homePage.acceptCookies();
	        homePage.closeOfferBox();
	        homePage.clickBodyCareDropdown();
	        	       	           	       
	     
	        
	     // Step 3: Navigate to Body Wash & Shower Gel page
	        ProductPage productPage = homePage.clickBodyCareDropdown();

	        List<String> productNames = Arrays.asList("Eucalyptus Spearmint", "Warm Vanilla Sugar", "A Thousand Wishes");
	        for (String productName : productNames) {
	        	productPage.addProductToCart(productName);
	        }
	        
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	        
	        //Step 4: go to cartPage	        	        
	       
	        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".minicart.bbw-minicart")));
	        // Scroll the page to the cart button
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", cartButton);            
	        cartButton.click();
	        
	        
	        //Step 5: go to checkout page	  
	        
	        WebElement checkOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Checkout']")));
	        // Scroll the page to the checkout button
	        js.executeScript("arguments[0].scrollIntoView(true);", checkOutButton);	        	      
	        checkOutButton.click();
             driver.quit();
             
             //updated on may 26,,,,
	      
	        
	        
     }
}