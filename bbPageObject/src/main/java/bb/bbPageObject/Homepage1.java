package bb.bbPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage1 {

    private WebDriver driver;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookiesAcceptButton;

    @FindBy(xpath = "//span[@class='nav-link__text '][normalize-space()='Body Care']")
    private WebElement bodyCareDropdown;

    @FindBy(xpath = "//span[normalize-space()='×']")
    private WebElement closeOfferBoxButton;

    @FindBy(xpath = "//ul[@aria-label='Bath & Shower']//a[@role='menuitem'][normalize-space()='Body Wash & Shower Gel']")
    private WebElement bodyWashAndShowerGel;
    
    public Homepage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        cookiesAcceptButton.click();
    }

    public void closeOfferBox() {
        closeOfferBoxButton.click();
    }
    
    
   
     public ProductPage clickBodyCareDropdown() {
   
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(bodyCareDropdown).perform();
    	// WebElement bodyWashAndShowerGel = driver.findElement(By.xpath("//ul[@aria-label='Bath & Shower']//a[@role='menuitem'][normalize-space()='Body Wash & Shower Gel']"));
	      bodyWashAndShowerGel.click();
		return null;
	      //head changed   
        
    } 
}
