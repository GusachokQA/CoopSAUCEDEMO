package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    private WebDriver driver;

    private By OVERWIEWSELECTOR = By.xpath("//div[text()='Checkout: Overview']");
    private By SHIPPINGSELECTOR = By.xpath("//div[text()='FREE PONY EXPRESS DELIVERY!']");
    private By FINISHBUTTONSELECTOR =By.cssSelector(".btn_action.cart_button");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened(){
        return driver.findElement(OVERWIEWSELECTOR).isDisplayed();
    }

    public boolean shippingInformation(){
        return driver.findElement(SHIPPINGSELECTOR).isDisplayed();
    }

    public void finishButton(){
        driver.findElement(FINISHBUTTONSELECTOR).click();
    }
}
