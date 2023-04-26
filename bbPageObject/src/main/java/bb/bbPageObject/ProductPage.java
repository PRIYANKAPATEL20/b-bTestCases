package bb.bbPageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.abstractComponent;

import java.util.Arrays;
import java.util.List;

public class ProductPage extends abstractComponent {
	 private static WebDriver driver;

	    @FindBy(xpath = "//div[@id='bbw-product-grid']/div[@class='product-tile-wrapper']")
	    private List<WebElement> productList;
	    @FindBy(xpath = "//*[@id=\"addToBagModal\"]/div/div/div[3]/div[2]/button[1]")
	    private WebElement continueShoppingButton;

	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void addProductToCart(String productName) {
	        WebElement product = productList.stream()
	                .filter(productX -> productX.findElement(By.xpath(".//div[@class='tile-body text-center']/a/div[@class='product-name-and-category']/div[@class='pdp-link product-name bbw-font--source-sans-pro-semibold']"))
	                        .getText().equals(productName))
	                .findFirst().orElse(null);

	        if (product != null) {
	            product.findElement(By.xpath(".//div[@class='col-sm-12']/button"))
	                    .click();

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	            WebElement continueShopping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addToBagModal\"]/div/div/div[3]/div[2]/button[1]")));
	            Actions actions = new Actions(driver);
	            actions.moveToElement(continueShoppingButton).click().build().perform();
	            // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='addToBagModal']//div[@class='modal-content']")));

	        }
	    }
	}