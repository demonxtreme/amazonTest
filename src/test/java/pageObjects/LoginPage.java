package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by alanpanno on 15/06/2017.
 */
public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "ap_email")
    public static WebElement email;

    @FindBy(id = "ap_password")
    public static WebElement password;

    @FindBy(id = "signInSubmit")
    public static WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void insertEmail(String mail){
        email.sendKeys(mail);
    }

    public void insertPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickSigningButton(){
        signInButton.click();
    }


}
