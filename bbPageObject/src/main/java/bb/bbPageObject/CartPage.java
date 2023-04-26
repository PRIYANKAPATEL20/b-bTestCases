package bb.bbPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(css = ".minicart.bbw-minicart")
    private WebElement cartButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCartButton() {
        cartButton.click();
    }
}
