package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.HomePage;
import pages.CartPage;

import java.util.logging.Level;

public class StepDefinition {
    static WebDriver driver;

    public void setBrowser(String browser) {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\driver\\chromedriver.exe");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    @Given(".*?open.*? \"(.*?)\" .* \"(.*?)\"$")
    public void openBrowserAndNavigateTo(String url, String browser) {
        setBrowser(browser);
        goToUrl(url);
    }

    @When(".*input username with \"(.*?)\"$")
    public void inputUsernameField(String text){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUsernameFieldIsDisplayed();
        loginPage.inputUsernameField(text);
    }

    @And(".*input password with \"(.*?)\"$")
    public void inputPasswordField(String text){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyPasswordFieldIsDisplayed();
        loginPage.inputPasswordField(text);
    }

    @And(".*click Login Button")
    public void clickLoginButtonInLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginButtonIsEnabled();
        loginPage.verifyLoginButtonIsDisplayed();
        loginPage.clickLoginButton();
    }

    @Then(".*?see Homepage Screen")
    public void verifyHomepageScreenInHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyTextLogoIsDisplayed();
        homePage.verifyTitlePageIsDisplayed();
        homePage.verifyShoppingCartIsDisplayed();
    }

    @When(".*Sort to see the highest price")
    public void clickSortButtonInHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.verifySortButtonIsDisplayed();
        homePage.verifySortButtonIsCLickable();
        homePage.verifyValueFiltering();
    }

    @And(".*click first product")
    public void clickFirstProductInHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyProductNameIsDisplayed();
        homePage.verifyProductNameIsCLickable();
        homePage.verifyProductPictureIsDisplayed();
        homePage.selectTheProduct();
    }

    @Then(".*see detail of Product Name with the Highest Price")
    public void verifyProductDetailPage() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyDetailProductNameIsDisplayed();
        homePage.verifyProductPictureIsDisplayed();
        homePage.clickChekoutProduct();
    }

    @When (".*checkout the product")
    public void checkoutTheProduct() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickShoppingCart();
        homePage.verifyProductIsAdded();
        homePage.verifyProductNameIsDisplayed();
        homePage.clickShoppingCart();
        cartPage.verifyProductCheckoutDisplayed();
        cartPage.verifyProductPriceDisplayed();
        cartPage.verifyContinueShoppingButtonIsDisplayed();
        cartPage.verifyContinueShoppingButtonIsClickable();
        cartPage.clickCheckoutButton();
    }

    @And("input firstname with \"(.*?)\"$")
    public void inputFirstNameField(String text){
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyFirstNameFieldIsDisplayed();
        cartPage.inputFirstNameField(text);
    }

    @And("input lastname with \"(.*?)\"$")
    public void inputLastNameField(String text){
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyLastNameFieldIsDisplayed();
        cartPage.inputLastNameField(text);
    }

    @And("input postal code with \"(.*?)\"$")
    public void inputPostalCodeFieldField(String text){
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyPostalCodeFieldIsDisplayed();
        cartPage.inputPostalCodeField(text);
    }

    @And(".*click Continue Button")
    public void clickContinueButtonInCartPage(){
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyContinueButtonIsEnabled();
        cartPage.verifyContinueButtonIsDisplayed();
        cartPage.clickContinueButton();
    }

    @And("verify order status")
    public void verifyOrderStatusInCartPage(){
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyCheckoutTitlePageIsDisplayed();
        cartPage.verifyCheckoutSummaryIsDisplayed();
        cartPage.clickFinishButton();
    }

    @Then("capture the screen")
    public void captureTheCompleteOrderScreen() {
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyCompleteOrderTitlePageIsDisplayed();
        cartPage.verifyBackHomeButtonIsDisplayed();
        cartPage.verifyBackHomeButtonIsClickable();
        cartPage.verifyCheckoutCompleteInfoIsDisplayed();
        cartPage.takeScreenshot();
    }
}
