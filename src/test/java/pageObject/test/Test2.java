package pageObject.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.pages.LoginPage;
import pageObject.pages.ProductsPage;

public class Test2 extends BaseTest{
    //Проверка работоспособности кнопки REMOVE на странице Your Cart (удаление выбранного товара из корзины)

    @Test
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
}
