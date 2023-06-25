package pages;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * List of element in Cart Page
     **/
    @FindBy(xpath = "//*[@class='inventory_item_price']")
    private WebElement cartPrice;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    private WebElement cartItemName;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShopping;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@class='title']")
    private WebElement titlePage;

    @FindBy(xpath = "//*[@class='summary_info']")
    private WebElement checkoutSummary;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(id = "checkout_complete_container")
    private WebElement checkoutComplete;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;



    /**
     * List of function in Cart Page
     **/
    public void verifyFirstNameFieldIsDisplayed(){
        assertTrue("Firstname textfield is not displayed!", firstNameField.isDisplayed());
    }

    public void inputFirstNameField(String text){
        firstNameField.sendKeys(text);
    }

    public void verifyLastNameFieldIsDisplayed(){
        assertTrue("Lastname textfield is not displayed!", lastNameField.isDisplayed());
    }

    public void inputLastNameField(String text){
        lastNameField.sendKeys(text);
    }

    public void verifyPostalCodeFieldIsDisplayed(){
        assertTrue("Postal Code textfield is not displayed!", postalCodeField.isDisplayed());
    }

    public void inputPostalCodeField(String text){
        postalCodeField.sendKeys(text);
    }

    public void verifyContinueButtonIsDisplayed(){
        assertTrue("Continue button is not displayed!", continueButton.isDisplayed());
    }

    public void verifyContinueButtonIsEnabled(){
        assertTrue("Continue Button is not clickable!", continueButton.isEnabled());
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void verifyProductCheckoutDisplayed() {
        assertTrue("Product Name is not displayed!", cartItemName.getText().toString().contains("Sauce Labs Fleece Jacket"));
    }

    public void verifyProductPriceDisplayed() {
        assertTrue("Product Price is not displayed!", cartPrice.getText().toString().contains("49.99"));
    }

    public void verifyContinueShoppingButtonIsDisplayed(){
        assertTrue("Continue Button is not displayed!", continueShopping.isDisplayed());
    }

    public void verifyContinueShoppingButtonIsClickable(){
        assertTrue("Continue Button is not clickable!", continueShopping.isEnabled());
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void verifyCheckoutTitlePageIsDisplayed(){
        assertTrue("Title Page is not displayed!", titlePage.getText().toString().contains("Checkout: Overview"));
    }

    public void verifyCheckoutSummaryIsDisplayed(){
        assertTrue("Payment Information is not displayed!", checkoutSummary.getText().toString().contains("Payment Information"));
        assertTrue("Shipping Information is not displayed!", checkoutSummary.getText().toString().contains("Shipping Information"));
        assertTrue("Total is not displayed!", checkoutSummary.getText().toString().contains("Total: "));
    }

    public void verifyCancelButtonIsDisplayed(){
        assertTrue("Cancel Button is not displayed!", cancelButton.isDisplayed());
    }

    public void verifyCancelButtonIsClickable(){
        assertTrue("Cancel Button is not clickable!", cancelButton.isEnabled());
    }

    public void verifyFinishButtonIsDisplayed(){
        assertTrue("Finish Button is not displayed!", finishButton.isDisplayed());
    }

    public void clickFinishButton(){
        finishButton.click();
    }

    public void verifyCompleteOrderTitlePageIsDisplayed(){
        assertTrue("Complete Title Page is not displayed!", titlePage.getText().toString().contains("Checkout: Complete!"));
    }

    public void verifyBackHomeButtonIsDisplayed(){
        assertTrue("Back Home Button is not displayed!", backHomeButton.isDisplayed());
    }

    public void verifyBackHomeButtonIsClickable(){
        assertTrue("Back Home Button is not clickable!", backHomeButton.isEnabled());
    }

    public void verifyCheckoutCompleteInfoIsDisplayed(){
        assertTrue("Checkout Complete is not displayed!", checkoutComplete.getText().toString().contains("Thank you for your order!"));
        assertTrue("Checkout Complete Information is not displayed!", checkoutComplete.getText().toString().contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
    }

    public void takeScreenshot() {
        /**
         * Get current dir path
         **/
        String directory = System.getProperty("user.dir");

        /**
         * Take a screenshot
         **/
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        /**
         * Copy the file to a location and use try catch block to handle exception
         **/
        try {
            FileUtils.copyFile(screenshot, new File(directory +"\\result\\CheckoutComplete.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
