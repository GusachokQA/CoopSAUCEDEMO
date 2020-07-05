package pageObject.allure.pagesAllure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.pages.BasePage;

public class InformPageAllure extends BasePageAllure {

    private By informLocator = By.xpath("//div[text()='Checkout: Your Information']");
    private By firstNameLocator = By.id("first-name");
    private By lastNameLocator = By.id("last-name");
    private By postalCodeLocator = By.id("postal-code");
    private By continueButtonFieldLocator = By.xpath("//input[@type='submit']");

    public InformPageAllure(WebDriver driver){
        super(driver);
    }

    public boolean isPageOpened(){
        return driver.findElement(informLocator).isDisplayed();
    }

    public WebElement getFirstNameField(){
        return driver.findElement(firstNameLocator);
    }

    public WebElement getLastNameField(){
        return driver.findElement(lastNameLocator);
    }

    public WebElement getPostalCodeField(){
        return driver.findElement(postalCodeLocator);
    }

    public WebElement getContinueButtonField(){
        return driver.findElement(continueButtonFieldLocator);
    }

    @Step("Continue Step with firstName {0}, lastName {1}, postalCode {2}")
    public void continueButton(String firstName, String lastName, String postalCode){
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getPostalCodeField().sendKeys(postalCode);
        getContinueButtonField().click();
    }
}
