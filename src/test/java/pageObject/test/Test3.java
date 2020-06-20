package pageObject.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.pages.InformPage;
import pageObject.pages.LoginPage;
import pageObject.pages.ProductsPage;
import pageObject.pages.YourCartPage;

public class Test3 extends BaseTest{
    //Проверить страницу Checkout: Your Information, появление ошибки Error: "First Name is required"
    // при нажатии кнопки CONTINUE без заполения данных

    @Test
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
        Assert.assertEquals(informPage.errorMessage(),"Error: First Name is required", "Что-то пошло не так");
    }
}
