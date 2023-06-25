package pages;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * List of element in Login Page
     **/
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    /**
     * List of function in Login Page
     **/
    public void verifyUsernameFieldIsDisplayed(){
        assertTrue("Username textfield is not displayed!", usernameField.isDisplayed());
    }

    public void inputUsernameField(String text){
        usernameField.sendKeys(text);
    }

    public void verifyPasswordFieldIsDisplayed(){
        assertTrue("Password textfield is not displayed!", passwordField.isDisplayed());
    }

    public void inputPasswordField(String text){
        passwordField.sendKeys(text);
    }

    public void verifyLoginButtonIsEnabled(){
        assertTrue("Login Button is not clickable!", loginButton.isEnabled());
    }

    public void verifyLoginButtonIsDisplayed(){
        assertTrue("Login Button is not displayed!", loginButton.isDisplayed());
    }

    public void clickLoginButton(){
        loginButton.click();
    }

}
