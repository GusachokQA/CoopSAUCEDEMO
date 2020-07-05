package pageObject.allure.testAllure;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.allure.pagesAllure.InformPageAllure;
import pageObject.allure.pagesAllure.LoginPageAllure;
import pageObject.allure.pagesAllure.ProductPageAllure;
import pageObject.allure.pagesAllure.YourCartPageAllure;

public class StepsTest extends BaseTestAllure{

    String username = "standard_user";
    String password = "secret_sauce";
    String firstName = "Vladimir";
    String lastName = "Gusachok";
    String postalCode = "123345";
    String productsName = "Sauce Labs Bolt T-Shirt";

    @Test
    public void loginTest(){
        LoginPageAllure loginPageAllure = new LoginPageAllure(getDriver(),URL);
        Assert.assertTrue(loginPageAllure.isPageOpened(),"Login page hasn't opened.");

        loginPageAllure.login(username, password);
    }

    @Test(dependsOnMethods = "loginTest")
    public void selectProduct(){
        ProductPageAllure productPageAllure = new ProductPageAllure(getDriver());
        Assert.assertTrue(productPageAllure.isPageOpened(), "Product page hasn't opened.");

        productPageAllure.addToCart(productsName);

    }

    @Test(dependsOnMethods = "selectProduct")
    public void yourCartPage(){
        YourCartPageAllure yourCartPageAllure = new YourCartPageAllure(getDriver());
        Assert.assertTrue(yourCartPageAllure.isPageOpened(), "YourCartPage page hasn't opened.");

        yourCartPageAllure.checkout(productsName);
    }

    @Test(dependsOnMethods = "yourCartPage")
    public void informPage(){
        InformPageAllure informPageAllure = new InformPageAllure(getDriver());
        Assert.assertTrue(informPageAllure.isPageOpened(), "InformPage page hasn't opened.");

        informPageAllure.continueButton(firstName, lastName, postalCode);
    }
}
