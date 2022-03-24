package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String elementWithText = "//*[contains(text(), '%s')]";

    @FindBy(xpath = "(//a[@data-controller='HeaderNavFolderTouch'])[4]")
    public WebElement menu;

    @FindBy(xpath = "//a[.='Cloud Software Engineer']")
    public WebElement cloudEngineer;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    public WebElement getElementWithText(String text) {
        return Driver.getDriver().findElement(By.xpath(String.format(elementWithText, text)));
    }
}
