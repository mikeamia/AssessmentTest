package pages;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * List of element in Home Page
     **/
    @FindBy(xpath = "//*[@class='app_logo']")
    private WebElement titlePage;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(xpath = "//*[@class='title']")
    private WebElement productsPage;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortButton;

    @FindBy(xpath = "//div[@class='inventory_item_label']")
    private WebElement selectlistingProducts;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    private WebElement productsTitle;

    @FindBy(xpath = "//*[@class='inventory_details_name large_size']")
    private WebElement detailProductsTitle;

    @FindBy(xpath = "//*[@alt='Sauce Labs Fleece Jacket']")
    private WebElement productsPicture;

    @FindBy(xpath = "//*[@class='inventory_details_price']")
    private WebElement productsPrice;

    @FindBy(xpath = "//*[@data-test='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement checkoutProducts;

    @FindBy(xpath = "//*[@data-test='remove-sauce-labs-fleece-jacket']")
    private WebElement removeCheckoutProducts;


    /**
     * List of function in Home Page
     **/
    public void verifyTextLogoIsDisplayed() {
        assertTrue("Text Logo is not displayed!", titlePage.getText().toString().contains("Swag Labs"));
    }

    public void verifyTitlePageIsDisplayed(){
        assertTrue("Title Page is not displayed!", productsPage.getText().toString().contains("Products"));
    }

    public void verifyShoppingCartIsDisplayed(){
        assertTrue("Shopping Cart is not displayed!", shoppingCart.isDisplayed());
    }

    public void clickShoppingCart(){
        shoppingCart.click();
    }

    public void verifySortButtonIsDisplayed(){
        assertTrue("Sort Button is not displayed!", sortButton.isDisplayed());
    }

    public void verifySortButtonIsCLickable(){
        assertTrue("Sort Button is not clickable!", sortButton.isEnabled());
    }

    public void selectValueFilter(){
        Select highestFiltered = new Select (sortButton);
        highestFiltered.selectByValue("hilo");
    }

    public void verifyValueFiltering(){
        /**
         * Get default value of the filter and save the value for comparation in array
         **/
        List<WebElement> selectDefaultlistingProducts = driver.findElements(By.className("inventory_item_price"));
        List<Double> sebelum = new ArrayList<>();
        for(WebElement seb : selectDefaultlistingProducts) {
            sebelum.add(Double.valueOf(seb.getText().replace("$","")));
        }

        /**
         * Do the filter
         **/
        Select highestFiltered = new Select (sortButton);
        highestFiltered.selectByValue("hilo");

        /**
         * Get value after the filtering and save the value for comparation in array
         **/
        List<WebElement> selectlistingProducts = driver.findElements(By.className("inventory_item_price"));
        List<Double> sesudah = new ArrayList<>();
        for(WebElement ses : selectlistingProducts) {
            sesudah.add(Double.valueOf(ses.getText().replace("$","")));
        }

        /**
         * Compare the value between before and after filter
         **/
        assertNotEquals(sebelum, sesudah);
    }

    public void verifyProductNameIsDisplayed(){
        assertTrue("Product Name is not displayed!", productsTitle.getText().toString().contains("Sauce Labs Fleece Jacket"));
    }

    public void verifyDetailProductNameIsDisplayed(){
        assertTrue("Detail Product Name is not displayed!", detailProductsTitle.getText().toString().contains("Sauce Labs Fleece Jacket"));
    }

    public void verifyProductNameIsCLickable(){
        assertTrue("Product Name Hyperlink is not clickable!", productsTitle.isEnabled());
    }

    public void verifyProductPictureIsDisplayed(){
        assertTrue("Product Picture is not displayed!", productsPicture.isDisplayed());
    }

    public void selectTheProduct(){
        productsPicture.click();
    }

    public void verifyProductPriceIsDisplayed(){
        assertTrue("Product Price is not displayed!", productsPrice.isDisplayed());
    }

    public void clickChekoutProduct(){
        checkoutProducts.click();
    }

    public void verifyProductIsAdded(){
        assertTrue("Product not added to cart yet!", removeCheckoutProducts.getText().toString().contains("Remove"));
    }

}
