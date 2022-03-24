package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SolliciterenPage {
    public SolliciterenPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//a[@data-controller='HeaderNavFolderTouch'])[4]")
    public WebElement menu;

    @FindBy(xpath = "//a[.='Cloud Software Engineer']")
    public WebElement cloudEngineer;

    @FindBy(xpath = "//a[contains(@class,'button-element')]")
    public WebElement solliciteren;
    //a[@class='sqs-block-button-element--medium sqs-button-element--primary sqs-block-button-element']

    @FindBy(xpath = "(//input[contains(@class,'field-element')])[1]")
    public WebElement firstName;
        @FindBy(xpath = "(//input[contains(@class,'field-element')])[2]")
    public WebElement lastName;
        @FindBy(xpath = "(//input[contains(@class,'field-element')])[3]")
    public WebElement e_mail;
        @FindBy(xpath = "(//input[contains(@class,'field-element')])[4]")
    public WebElement phoneNumber;
        @FindBy(xpath = "(//input[contains(@class,'field-element')])[5]")
    public WebElement linkedIn;
        @FindBy(xpath = "//textarea")
    public WebElement motivatie;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//*[contains(text(), 'Dankjewel voor je sollicitatie!')]")
    public WebElement submitMessage;
    //div[@class='form-submission-text']

}
