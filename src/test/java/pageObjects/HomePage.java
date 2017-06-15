package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alanpanno on 14/06/2017.
 */
public class HomePage {

    @FindBy(id = "twotabsearchtextbox")
    public static WebElement searchField;


    @FindBy(id = "nav-search-submit-text")
    public static WebElement searchButton;

    @FindBy(xpath = "//li[@id='result_1']/div/div[2]")
    public static WebElement element1;

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String name){
        searchField.sendKeys(name);
        searchButton.click();
    }

    public void clickProduct(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(element1));
        element.click();
    }


}
