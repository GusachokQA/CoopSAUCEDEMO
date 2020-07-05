package pageObject.allure.testAllure;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import pageObject.allure.utils.ListenerTestAllure;
import pageObject.webcore.BrowserService;


@Listeners(ListenerTestAllure.class)
public class BaseTestAllure {
    public static WebDriver driver;

    String URL;
    BrowserService browserService = new BrowserService();

    @Parameters("URL")
    @BeforeClass
    public void setUp(String URL){
        driver = browserService.initBrowser();
        this.URL = URL;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
