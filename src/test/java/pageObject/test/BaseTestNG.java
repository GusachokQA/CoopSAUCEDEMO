package pageObject.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.webcore.BrowserService;

@Listeners(ListenerTest.class)
public class BaseTestNG {
    WebDriver driver;
    BrowserService browserService = new BrowserService();

    @BeforeMethod
    public void setUp(){
        driver = browserService.initBrowser();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
