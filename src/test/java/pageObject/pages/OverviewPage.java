package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {
    private WebDriver driver;

    private By OVERWIEWSELECTOR = By.xpath("//div[text()='Checkout: Overview']");
    private By SHIPPINGSELECTOR = By.xpath("//div[text()='FREE PONY EXPRESS DELIVERY!']");
    private By FINISHBUTTONSELECTOR = By.cssSelector(".btn_action.cart_button");
    private By CARTCOUNTSELECTION = By.cssSelector(".summary_quantity");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened(){
        return driver.findElement(OVERWIEWSELECTOR).isDisplayed();
    }

    public int getQuantityCount(){
        //WebElement cartSelectedCount = driver.findElement(CARTCOUNTSELECTION);
        return driver.findElements(CARTCOUNTSELECTION).size();
    }

    public String getValueLabel(){
        return driver.findElement(SHIPPINGSELECTOR).getText();
    }

    public void finishButton(){
        driver.findElement(FINISHBUTTONSELECTOR).click();
    }
}
