package pageObject.allure.pagesAllure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.pages.BasePage;

public class YourCartPageAllure extends BasePageAllure {

    private By yourCartPageFieldLocator = By.xpath("//div[text()='Your Cart']");
    private By checkOutButtonFieldLocator = By.className("checkout_button");
    private By quantityFieldLocator = By.cssSelector(".cart_quantity");

    public YourCartPageAllure(WebDriver driver){
        super(driver);
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public boolean isPageOpened() {
        return getYourCartPageField().isDisplayed();
    }

    public WebElement getYourCartPageField(){
        return driver.findElement(yourCartPageFieldLocator);
    }

    public WebElement getQuantityField(){
        return driver.findElement(quantityFieldLocator);
    }

    public WebElement getCheckOutButtonField(){
        return driver.findElement(checkOutButtonFieldLocator);
    }

    @Step("Check product {0} in cart and click CHECKOUT.")
    public void checkout(String name){
        getYourCartPageField();
        getQuantityField();
        getCheckOutButtonField().click();
    }
}
