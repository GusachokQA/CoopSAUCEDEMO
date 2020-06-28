package pageObject.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.pages.LoginPage;

public class FactoryRegression extends BaseTest{
    @Test(priority = 2)
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

    @Test(priority = 2)
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
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Sorry, this user has been locked out.", "Что- пошло не так");
    }
}
