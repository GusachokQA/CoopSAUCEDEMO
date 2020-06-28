package pageObject.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.pages.*;

public class TestNG extends BaseTest {
    String username = "standard_user";
    String password = "secret_sauce";

    String firstName = "Ivan";
    String lastName = "Ivanov";
    String postCode = "12345";

    @Test
    public void loginPage() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page has not been opened.");
        loginPage.login(username, password);
    }

    @Test(dependsOnMethods = "loginPage")
    public void productPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened());
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(productsPage.getCartSelectedCount(), "1",
                "Количество выбранный элементов не верно.");
    }

    @Test(dependsOnMethods = "productPage")
    public void yourCartPage() {
        YourCartPage yourCartPage = new YourCartPage(driver);
        Assert.assertTrue(yourCartPage.isPageOpened(), "YourCard page has not been opened");
        Assert.assertEquals(yourCartPage.getQuantityCount(), 1,
                "Количетсво добавленных элементов не равно 1");
        yourCartPage.checkOutButton();
    }

    @Test(dependsOnMethods = "yourCartPage")
    public void informPage() {
        InformPage informPage = new InformPage(driver);
        Assert.assertTrue(informPage.isPageOpened(), "Inform page has not been opened");
        informPage.customerDate(firstName, lastName, postCode);
    }

    @Test(dependsOnMethods = "informPage")
    public void overviewPage() {
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page has not been opened");
        Assert.assertEquals(overviewPage.getQuantityCount(), 1,
                "Количетсво добавленных элементов не равно 1");
        Assert.assertEquals(overviewPage.getValueLabel(), "FREE PONY EXPRESS DELIVERY!",
                "Что-то пошло не так!!!");
        overviewPage.finishButton();
    }

    @Test(dependsOnMethods = "overviewPage")
    public void finishPage(){
        FinishPage finishPage = new FinishPage(driver);
        Assert.assertTrue(finishPage.isPageOpened(), "FinishPage page has not been opened");
        Assert.assertEquals(finishPage.getThankYouText(),
                "THANK YOU FOR YOUR ORDER", "Что-то пошло не так!!!");
    }
}
