package pageObject.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.webcore.BrowserService;
import org.testng.annotations.Listeners;


@Listeners(ListenerTest.class)
public class BaseTest {
    WebDriver driver;
    BrowserService browserService = new BrowserService();

    @BeforeGroups
    public void beforeGroup(){
        driver = browserService.initBrowser();
    }

    @BeforeClass
    public void setUp(){
        driver = browserService.initBrowser();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterGroups
    public void afterGroup(){
        driver.quit();
    }
}
