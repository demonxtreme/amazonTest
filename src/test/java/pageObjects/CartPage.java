package pageObjects;

import main.src.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alanpanno on 15/06/2017.
 */
public class CartPage {

    private WebDriver driver;

    @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
    private static WebElement productName;

    @FindBy(css = "p.a-spacing-small > span.a-size-medium")
    private static WebElement productPrice;

    @FindBy(xpath = "//input[@name='proceedToCheckout']")
    private static WebElement proceedCheckout;



    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkUrl() {
        if(!driver.getCurrentUrl().contains("cart")){
            return false;
        }
        return true;
    }

    public String getProductName(){
        return productName.getText().substring(0,20);
    }
    public String getProductPrice(){
        return productPrice.getText();
    }

    public void clickProceedCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(proceedCheckout));
        element.click();
    }
}
