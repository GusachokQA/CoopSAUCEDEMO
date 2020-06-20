package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    private By PRODUCTSELECTOR = By.className("product_label");
    private By CARTCOUNTICONSELECTOR = By.cssSelector(".fa-layers-counter.shopping_cart_badge");

    private String itemIdentificator = "//div[text()='replace']/ancestor::div[@class='inventory_item']";
    private String itemButtonIdentificator = itemIdentificator + "/descendant::button";
    private String itemNameIdentificator = itemIdentificator + "/descendant::div[@class = 'inventory_item_name']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(PRODUCTSELECTOR).isDisplayed();
    }

    public void addToCart(String name) {
        String tmpItemIdentificator = itemButtonIdentificator.replace("replace", name);
        WebElement addCartButton = driver.findElement(By.xpath(tmpItemIdentificator));
        addCartButton.click();
    }

    public String getCartSelectedName(String name) {
        String tmpItemNameIdentificator = itemNameIdentificator.replace("replace", name);
        WebElement selectionName = driver.findElement(By.xpath(tmpItemNameIdentificator));

        return selectionName.getText();
    }

    public String getCartSelectedCount() {
        WebElement cartCountIcon = driver.findElement(CARTCOUNTICONSELECTOR);
        return cartCountIcon.getText();
    }

    public void removeToCart(String name){
        String tmpItemIdentificator = itemButtonIdentificator.replace("replace", name);
        WebElement addCartButton = driver.findElement(By.xpath(tmpItemIdentificator));
        addCartButton.click();
    }
}
