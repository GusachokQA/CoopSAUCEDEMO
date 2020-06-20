package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage extends BasePage{

    private By FIFNSHSELECTOR = By.xpath("//div[text()='Finish']");
    private By THANKYOUSELECTOR = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(FIFNSHSELECTOR).isDisplayed();
    }

    public String getThankYouText(){
        return driver.findElement(THANKYOUSELECTOR).getText();
    }

}
