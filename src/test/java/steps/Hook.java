package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by alanpanno on 28/05/2017.
 */
public class Hook {

    String geckoPath = "/Users/alanpanno/Desktop/dev/nestleAutomation/src/test/resources/";
    public WebDriver driver;


    @Before
    public void initializeBrowser(){

        System.out.println("opening browser");
        System.out.println("Starting Firefox browser");
        System.setProperty("webdriver.gecko.driver", geckoPath + "geckodriver");


    }


    @After
    public void closingBrowser(){
        System.out.println("closing browser");
        if(driver!=null) {
            driver.close();
        }

    }


}
