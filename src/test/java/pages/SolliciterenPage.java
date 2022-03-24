package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SolliciterenPage extends BasePage {

    public SolliciterenPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Solliciteren')]")
    public WebElement apply;
    @FindBy(xpath = "(//input[contains(@class,'field-element')])[1]")
    public WebElement firstName;
    @FindBy(xpath = "(//input[contains(@class,'field-element')])[2]")
    public WebElement lastName;
    @FindBy(xpath = "(//input[contains(@class,'field-element')])[3]")
    public WebElement e_mail;
    @FindBy(xpath = "(//input[contains(@class,'field-element')])[4]")
    public WebElement phoneNumber;
}
