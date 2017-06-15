package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.src.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by alanpanno on 14/06/2017.
 */
public class BuySteps {

    public WebDriver driver;
    private Product product;

    public BuySteps() {

       driver = new FirefoxDriver();
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, ProductPage.class);
        PageFactory.initElements(driver, CartPage.class);
        PageFactory.initElements(driver, LoginPage.class);
        product = new Product();
    }


    @Given("^I am on amazon home page$")
    public void iAmOnAmazonHomePage() throws Throwable {
        driver.navigate().to("https://www.amazon.co.uk/");
    }

    @When("^I search \"([^\"]*)\" on amazon$")
    public void iSearchOnAmazon(String name) throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HomePage home = new HomePage(driver);
        home.searchProduct(name);
    }


    @And("^I click first item on the list$")
    public void iClickFirstItemOnTheList() throws Throwable {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        HomePage home = new HomePage(driver);
        home.clickProduct();
    }

    @And("^I am on product page$")
    public void iAmOnProductPage() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.checkUrl(), "not in product page");

    }

    @And("^I select the size of the shoes$")
    public void iSelectTheSizeOfTheShoes() throws Throwable {
        ProductPage productPage = new ProductPage(driver);
        productPage.selectRandomSize();
    }

    @And("^I click add to basket button$")
    public void iClickAddToBasketButton() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        ProductPage productPage = new ProductPage(driver);
        product.setPrice(productPage.getPrice());
        product.setName(productPage.getProductTitle());
        productPage.clickAddToCartButton();
    }

    @And("^I verify the correct item in the cart$")
    public void iVerifyTheCorrectItemInTheCart() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ProductPage productPage = new ProductPage(driver);
        productPage.clickEditBasket();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.checkUrl(), "not in cart page");
//        Assert.assertTrue(cartPage.getProductName().contains(product.getName()), "invalid product name");
        Assert.assertTrue(cartPage.getProductPrice().contains(product.getPrice()), "invalid product price");


    }

    @And("^I click proceed to checkout$")
    public void iClickProceedToCheckout() throws Throwable {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickProceedCheckout();
    }

    @And("^I insert my email \"([^\"]*)\" and pass \"([^\"]*)\"$")
    public void iInsertMyEmailAndPass(String arg0, String arg1) throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertEmail(arg0);
        loginPage.insertPassword(arg1);
    }

    @And("^I click sign in button$")
    public void iClickSignInButton() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSigningButton();

    }

    @Then("^I am on delivery address$")
    public void iAmOnDeliveryAddress() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getCurrentUrl().contains("addressselect"));
    }

    @After
    public void closingBrowser(){
        System.out.println("closing browser");
        if(driver!=null) {
            driver.close();
        }

    }


}
