package pageObject.allure.testAllure;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.pages.*;

public class AllureDescriptionTest extends BaseTestAllure{

    @Description("Main Page Test_1")
    @Test(description = "Main Page Test with 1 product")
    public void mainPage_1() {
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
        Assert.assertEquals(productsPage.getCartSelectedCount(), "1",
                "Количество выбранный элементов не верно.");

        //YourCartPage
        YourCartPage yourCartPage = new YourCartPage(driver);
        Assert.assertTrue(yourCartPage.isPageOpened(), "YourCard page has not been opened");

        Assert.assertEquals(yourCartPage.getQuantityCount(), 1,
                "Количетсво добавленных элементов не равно 1");

        yourCartPage.checkOutButton();

        //InformPage
        InformPage informPage = new InformPage(driver);
        Assert.assertTrue(informPage.isPageOpened(), "Inform page has not been opened");

        informPage.customerDate(firstName, lastName, postCode);

        //OverviewPage
        OverviewPage overviewPage = new OverviewPage(driver);

        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page has not been opened");
        Assert.assertEquals(overviewPage.getQuantityCount(), 1,
                "Количетсво добавленных элементов не равно 1");
        Assert.assertEquals(overviewPage.getValueLabel(), "FREE PONY EXPRESS DELIVERY!",
                "Что-то пошло не так!!!");

        overviewPage.finishButton();

        //FinishPage
        FinishPage finishPage = new FinishPage(driver);
        Assert.assertTrue(finishPage.isPageOpened(), "FinishPage page has not been opened");

        Assert.assertEquals(finishPage.getThankYouText(),
                "THANK YOU FOR YOUR ORDER", "Что-то пошло не так!!!");
    }

    @Description("Main Page Test_2")
    @Test(description = "Main Page Test with 2 product")
    public void mainPage_2() {
        String username = "standard_user";
        String password = "secret_sauce";

        String firstName = "Ivan";
        String lastName = "Ivanov";
        String postCode = "12345";

        //LoginPage
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page has not been opened.");

        loginPage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isPageOpened());

        //ProductPage
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        Assert.assertEquals(productsPage.getCartSelectedCount(), "2",
                "Количество выбранный элементов не верно.");

        //YourCartPage
        YourCartPage yourCartPage = new YourCartPage(driver);
        Assert.assertTrue(yourCartPage.isPageOpened(), "YourCard page has not been opened");

        Assert.assertEquals(yourCartPage.getQuantityCount(), 2,
                "Количетсво добавленных элементов не равно 2");

        yourCartPage.checkOutButton();

        //InformPage
        InformPage informPage = new InformPage(driver);
        Assert.assertTrue(informPage.isPageOpened(), "Inform page has not been opened");

        informPage.customerDate(firstName, lastName, postCode);

        //OverviewPage
        OverviewPage overviewPage = new OverviewPage(driver);

        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page has not been opened");
        Assert.assertEquals(overviewPage.getQuantityCount(), 2,
                "Количетсво добавленных элементов не равно 2");
        Assert.assertEquals(overviewPage.getValueLabel(), "FREE PONY EXPRESS DELIVERY!",
                "Что-то пошло не так!!!");

        overviewPage.finishButton();

        //FinishPage
        FinishPage finishPage = new FinishPage(driver);
        Assert.assertTrue(finishPage.isPageOpened(), "FinishPage page has not been opened");

        Assert.assertEquals(finishPage.getThankYouText(),
                "THANK YOU FOR YOUR ORDER", "Что-то пошло не так!!!");
    }

    @Description("Login Test_1")
    @Test(description = "Test correct user")
    public void testLogin(){

        String username = "standard_user";
        String password = "secret_sauce";

        //1. Зайти на сайт https://www.saucedemo.com/
        LoginPage loginPage = new LoginPage(driver);
        //2. Проверить открылась ли страница
        Assert.assertTrue(loginPage.isPageOpened(),"Login page has not been opened.");
        //3. Ввести username и password и нажать кнопку Login
        loginPage.login(username, password);
    }

    @Description("Login Test_2")
    @Test(description = "Test locked user")
    public void testLoginError(){
        // Проверка авторизации на странице LoginPage заблокированным пользователем.
        String username = "locked_out_user";
        String password = "secret_sauce";

        //1. Зайти на сайт https://www.saucedemo.com/
        LoginPage loginPage = new LoginPage(driver);
        //2. Проверить открылась ли страница
        Assert.assertTrue(loginPage.isPageOpened(),"Login page has not been opened.");
        //3. Ввести username и password и нажать кнопку Login
        loginPage.login(username, password);
        //4. Проверить появление ошибки "Epic sadface: Sorry, this user has been locked out."
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Sorry, this user has been locked out.",
                "Что- пошло не так");
    }

    @Description("Test Remove Button")
    @Test(description = "Test Remove Button")
    public void testRemoveButton(){

        String username = "standard_user";
        String password = "secret_sauce";

        //1. Зайти на сайт https://www.saucedemo.com/
        LoginPage loginPage = new LoginPage(driver);
        //2. Проверить открылась ли страница
        Assert.assertTrue(loginPage.isPageOpened(),"Login page has not been opened.");
        //3. Ввести username и password и нажать кнопку Login
        loginPage.login(username, password);
        //4. Добавить 2 товара в корзину
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        //5. Проверить наличие в корзине 2 товаров
        Assert.assertEquals(productsPage.getCartSelectedCount(), "2",
                "Количество выбранный элементов не верно.");
        //4. Нажать кнопку REMOVE товара "Sauce Labs Onesie"
        productsPage.removeToCart("Sauce Labs Onesie");
        //5. Проверить, что в корзине остался 1 товар "Sauce Labs Fleece Jacket"
        Assert.assertEquals(productsPage.getCartSelectedName("Sauce Labs Fleece Jacket"),
                "Sauce Labs Fleece Jacket",
                "Что-то пошло не так");
    }

    @Description("Test Error Message")
    @Test(description = "Test Error: 'First Name is required'")
    public void testErrorMessage(){
        String username = "standard_user";
        String password = "secret_sauce";

        //1. Зайти на сайт https://www.saucedemo.com/
        LoginPage loginPage = new LoginPage(driver);
        //2. Проверить открылась ли страница
        Assert.assertTrue(loginPage.isPageOpened(),"Login page has not been opened.");
        //3. Ввести username и password и нажать кнопку Login
        loginPage.login(username, password);
        //4. Добавить 1 товар в корзину
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        //5. Перейти на страницу Checkout: Your Information
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.checkOutButton();
        //6. Нажать кнопку CONTINUE без заполения данных
        InformPage informPage = new InformPage(driver);
        informPage.continueButton();
        //7. Проверить появление ошибки Error: "First Name is required"
        Assert.assertEquals(informPage.errorMessage(),"Error: First Name is required",
                "Что-то пошло не так");
    }
}
