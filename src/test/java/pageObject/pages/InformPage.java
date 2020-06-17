package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformPage {
    private WebDriver driver;

    private By INFORMSELECTOR = By.xpath("//div[text()='Checkout: Your Information']");
    private By FIRSTNAMESELECTOR = By.id("first-name");
    private By LASTNAMESELECTOR = By.id("last-name");
    private By POSTALCODESELECTOR = By.id("postal-code");
    private By CONTINUEBUTTONSELECTOR = By.xpath("//input[@type=\"submit\"]");

    public InformPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isPageOpened(){
        return driver.findElement(INFORMSELECTOR).isDisplayed();
    }

    public void customerDate(String firstName, String lastName, String postlCode){
        driver.findElement(FIRSTNAMESELECTOR).sendKeys(firstName);
        driver.findElement(LASTNAMESELECTOR).sendKeys(lastName);
        driver.findElement(POSTALCODESELECTOR).sendKeys(postlCode);

        driver.findElement(CONTINUEBUTTONSELECTOR).click();
    }
}
