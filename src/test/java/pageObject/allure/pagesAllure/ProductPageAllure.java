package pageObject.allure.pagesAllure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageAllure extends BasePageAllure {
    // Locators
    private By productLocator = By.className("product_label");
    private String itemLocator = "//div[text()='replace']/ancestor::div[@class='inventory_item']";
    private String itemButtonLocator = itemLocator + "/descendant::button";
    private String itemPriceLocator = itemLocator + "/descendant::div[@class='inventory_item_price']";
    private String itemDescriptionLocator = itemLocator + "/descendant::div[@class='inventory_item_desc']";
    private By cartCountIconLocator = By.cssSelector(".fa-layers-counter.shopping_cart_badge");
    private By bucketIconLocator = By.tagName("svg");


    // General methods
    public ProductPageAllure(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(productLocator).isDisplayed();
    }

    // Elements getters
    public WebElement getAddCartButton(String itemName) {
        return driver.findElement(By.xpath(updateLocator(itemButtonLocator, itemName)));
    }

    public String getPrice(String name) {
        WebElement price = driver.findElement(By.xpath(updateLocator(itemPriceLocator, name)));
        return price.getText();
    }

    public String getCartSelectedCount() {
        WebElement cartCount = driver.findElement(cartCountIconLocator);
        return cartCount.getText();
    }

    // Steps
    @Step("Add item {name} to the bucket.")
    public void addToCart(String name) {
        getAddCartButton(name).click();

    }
/*
    public void goToBucket() {
        WebElement bucketIcon = driver.findElement(bucketIconLocator);
        bucketIcon.click();
    }

    public String getDescription(String name) {
        String tmpitemDescriptionidentificator = itemDescriptionLocator.replace("replace", name);
        WebElement description = driver.findElement(By.xpath(tmpitemDescriptionidentificator));
        return description.getText();
    }

    public String addButtonIsDisplayed(String name) {
        String tmpItemButtonidentificator = itemButtonLocator.replace("replace", name);
        WebElement addCartButton = driver.findElement(By.xpath(tmpItemButtonidentificator));
        return addCartButton.getText();
    }

 */
}
