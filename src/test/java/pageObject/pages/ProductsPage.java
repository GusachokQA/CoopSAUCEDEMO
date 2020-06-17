package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;

    private By PRODUCTSELECTOR = By.className("product_label");
    private By CARTCOUNTICONSELECTOR = By.cssSelector(".fa-layers-counter.shopping_cart_badge");

    private String itemIdentificator = "//div[text()='replace']/ancestor::div[@class='inventory_item']";
    private String itemButtonIdentificator = itemIdentificator + "/descendant::button";
    private String itemPriceIdentificator = itemIdentificator + "/descendant::div[@class = 'inventory_item_price']";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened() {
        return driver.findElement(PRODUCTSELECTOR).isDisplayed();
    }

    public void addToCart(String name) {
        String tmpItemIdentificator = itemButtonIdentificator.replace("replace", name);
        WebElement addCartButton = driver.findElement(By.xpath(tmpItemIdentificator));
        addCartButton.click();
    }

    public String getPrice(String name) {
        String tmpItemPriceIdentificator = itemPriceIdentificator.replace("replace", name);
        WebElement price = driver.findElement(By.xpath(tmpItemPriceIdentificator));

        return price.getText();
    }

    public String getCartSelectedCount() {
        WebElement cartCountIcon = driver.findElement(CARTCOUNTICONSELECTOR);
        return cartCountIcon.getText();
    }
}
