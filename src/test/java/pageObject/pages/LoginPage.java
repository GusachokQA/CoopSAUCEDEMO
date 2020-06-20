package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private By loginButtonSelector = By.xpath("//input[@value='LOGIN']");
    private By USERNAMESELECTOR = By.id("user-name");
    private By PASSWORDSELECTOR = By.id("password");
    private By ERRORSELECTOR = By.tagName("h3");


    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.saucedemo.com/");
    }

    public boolean isPageOpened() {
        WebElement loginButton = driver.findElement(loginButtonSelector);

        return loginButton.isDisplayed();
    }

    // Functional methods
    public void login(String username, String password) {
        driver.findElement(USERNAMESELECTOR).sendKeys(username);
        driver.findElement(PASSWORDSELECTOR).sendKeys(password);

        driver.findElement(loginButtonSelector).click();
    }

    public String getError() {
        return driver.findElement(ERRORSELECTOR).getText();
    }

}
