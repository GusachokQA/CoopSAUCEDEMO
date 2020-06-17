package pageObject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.pages.*;

public class MainPageTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void test1() {
        String username = "standard_user";
        String password = "secret_sauce";

        String firstName = "Ivan";
        String lastName = "Ivanov";
        String postCode = "12345";

        //LoginPage
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page has not been opened.");

        loginPage.login(username, password);

        //ProductPage
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened());

        productsPage.addToCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(productsPage.getCartSelectedCount(), "1", "Количество выбранный элементов не верно.");

        //YourCartPage
        YourCartPage yourCartPage = new YourCartPage(driver);
        Assert.assertTrue(yourCartPage.isPageOpened(), "YourCard page has not been opened");

        Assert.assertEquals(yourCartPage.getQuantityCount(), "1", "Количетсво добавленных элементов не равно 1");

        yourCartPage.checkOutButton();

        //InformPage
        InformPage informPage = new InformPage(driver);
        Assert.assertTrue(informPage.isPageOpened(), "Inform page has not been opened");

        informPage.customerDate(firstName, lastName, postCode);

        //OverviewPage
        OverviewPage overviewPage = new OverviewPage(driver);

        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page has not been opened");
        Assert.assertEquals(overviewPage.getQuantityCount(), "1", "Количетсво добавленных элементов не равно 1");
        Assert.assertEquals(overviewPage.getValueLabel(), "FREE PONY EXPRESS DELIVERY!", "Что-то пошло не так!!!");

        overviewPage.finishButton();

        //FinishPage
        FinishPage finishPage = new FinishPage(driver);
        Assert.assertTrue(finishPage.isPageOpened(), "FinishPage page has not been opened");

        Assert.assertEquals(finishPage.getThankYouText(),
                "THANK YOU FOR YOUR ORDER", "Что-то пошло не так!!!");
    }

    @Test
    public void test2() {
        String username = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page has not been opened.");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened());

        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        Assert.assertEquals(productsPage.getCartSelectedCount(), "2", "Количество выбранный элементов не верно.");

        driver.get("https://www.saucedemo.com/cart.html");

        Assert.assertEquals(driver.findElements(By.className("cart_item")).size(), 2, "Количетсво добавленных элементов не равно 1");

        driver.findElement(By.className("checkout_button")).click();
        driver.findElement(By.id("first-name")).sendKeys("Alex");
        driver.findElement(By.id("last-name")).sendKeys("Trostyanko");
        driver.findElement(By.id("postal-code")).sendKeys("220000");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Assert.assertEquals(driver.findElements(By.className("cart_item")).size(), 2, "Количетсво добавленных элементов не равно 1");
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'FREE PONY EXPRESS DELIVERY!']")).isDisplayed(), "Текст отсутствует.");
        driver.findElement(By.cssSelector(".btn_action.cart_button")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),
                "THANK YOU FOR YOUR ORDER", "Что-то пошло не так!!!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
