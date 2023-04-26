package bb.bbPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckOutPage {
	
	
	private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Checkout']")
    private WebElement checkOutButton;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckOutButton()  {
    	checkOutButton.click();
    }
    
}
