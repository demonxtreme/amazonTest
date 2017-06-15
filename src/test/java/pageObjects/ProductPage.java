package pageObjects;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alanpanno on 14/06/2017.
 */
public class ProductPage {

    private WebDriver driver;

    @FindBy(id = "native_dropdown_selected_size_name")
    private static WebElement dropdownSize;

    @FindBy(id = "add-to-cart-button")
    private static WebElement addToCartButton;

    @FindBy(id = "hlb-view-cart-announce")
    private static WebElement editBasket;

    @FindBy(id = "productTitle")
    private static WebElement productTitle;

    @FindBy(id = "priceblock_ourprice")
    private static WebElement price;



    public ProductPage(WebDriver driver) {
        this.driver = driver;

    }

    public Boolean checkUrl() {
        if(!driver.getCurrentUrl().contains("Nike")){
            return false;
        }
        return true;
    }

    public void selectRandomSize(){
        Select select = new Select(dropdownSize);
        select.selectByIndex(2);
    }


    public void clickAddToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        element.click();
    }

    public void clickEditBasket(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(editBasket));
        element.click();
    }

    public String getProductTitle(){
        return productTitle.getText();
    }

    public String getPrice(){
        return price.getText();
    }

}
