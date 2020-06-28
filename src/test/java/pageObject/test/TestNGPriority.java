package pageObject.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.pages.*;

public class TestNGPriority extends BaseTestNG {
    //String username = "standard_user";
    //String password = "secret_sauce";

    //String usernameError = "locked_out_user";
    //String passwordError = "secret_sauce";

    @Parameters({"username", "password"})
    @Test(priority = 4)
    public void testLogin(String username, String password){

        //1. Зайти на сайт https://www.saucedemo.com/
        LoginPage loginPage = new LoginPage(driver);
        //2. Проверить открылась ли страница
        Assert.assertTrue(loginPage.isPageOpened(),"Login page has not been opened.");
        //3. Ввести username и password и нажать кнопку Login
        loginPage.login(username, password);
    }

    @Parameters({"usernameError", "passwordError"})
    @Test(priority = 3)
    public void testLoginError(String usernameError, String passwordError){
        // Проверка авторизации на странице LoginPage заблокированным пользователем.

        //1. Зайти на сайт https://www.saucedemo.com/
        LoginPage loginPage = new LoginPage(driver);
        //2. Проверить открылась ли страница
        Assert.assertTrue(loginPage.isPageOpened(),"Login page has not been opened.");
        //3. Ввести username и password и нажать кнопку Login
        loginPage.login(usernameError, passwordError);
        //4. Проверить появление ошибки "Epic sadface: Sorry, this user has been locked out."
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Sorry, this user has been locked out.",
                "Что- пошло не так");
    }

    @Parameters({"username", "password"})
    @Test(priority = 2)
    public void testRemoveButton(String username, String password){

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

    @Parameters({"username", "password"})
    @Test(priority = 1)
    public void testErrorMessage(String username, String password){

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
