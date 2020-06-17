package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage {
    private WebDriver driver;

    private By YOURCARTSELECTOR = By.xpath("//div[text()='Your Cart']");
    private By CHECKOUTBUTTONSELECTOR = By.className("checkout_button");
    private By QUANTITYSELECTOR = By.cssSelector(".cart_quantity");

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public boolean isPageOpened(){
        return driver.findElement(YOURCARTSELECTOR).isDisplayed();
    }

    public int getQuantityCount(){
        return driver.findElements(QUANTITYSELECTOR).size();
    }

    public void checkOutButton(){
        driver.findElement(CHECKOUTBUTTONSELECTOR).click();
    }
}
