package pageObject.allure.pagesAllure;

import org.openqa.selenium.WebDriver;

public class BasePageAllure{
    WebDriver driver;

    public BasePageAllure(WebDriver driver) {
        this.driver = driver;
    }

    public String updateLocator(String locator, String value) {
        return locator.replace("replace", value);
    }
}
