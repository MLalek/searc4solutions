package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.SolliciterenPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SolliciterenStepdef {

    SolliciterenPage solliciterenPage = new SolliciterenPage();
    Actions action = new Actions(Driver.getDriver());

    @Given("user is on the search4solutions page")
    public void user_is_on_the_search4solutions_page() {
        Driver.getDriver().get(ConfigReader.getProperty("search4solutions_url"));

    }

    @Given("user hover over Werken bij on the menu")
    public void user_hover_over_werken_bij_on_the_menu() {
        ReusableMethods.hover(solliciterenPage.menu);

    }

    @Given("user choose Cloud Engineer")
    public void user_choose_cloud_engineer() {
        solliciterenPage.cloudEngineer.click();
    }

    @When("user click to button Solliciteren")
    public void userClickToButtonSolliciteren() {
        solliciterenPage.solliciteren.click();
    }

    @And("user fills out the form first name {string}")
    public void userFillsOutTheFormFirstName(String firstName) {
        solliciterenPage.firstName.sendKeys(firstName);

    }

    @And("user fills out the form last name {string}")
    public void userFillsOutTheFormLastName(String lastName) {
        solliciterenPage.lastName.sendKeys(lastName);
    }

    @And("user fills out the form e-mail {string}")
    public void userFillsOutTheFormEMail(String e_mail) {
        solliciterenPage.e_mail.sendKeys(e_mail);
    }

    @And("user fills out the form Telefoonnummer {string}")
    public void userFillsOutTheFormTelefoonnummer(String phoneNumber) {
        solliciterenPage.phoneNumber.sendKeys(phoneNumber);
    }

    @And("user fills out the form linkedIn Url {string}")
    public void userFillsOutTheFormLinkedInUrl(String linkedIn) {
        solliciterenPage.linkedIn.sendKeys(linkedIn);
    }

    @And("user fills out the form motivatie {string}")
    public void userFillsOutTheFormMotivatie(String motivatie) {
        solliciterenPage.motivatie.sendKeys(motivatie);
    }

    @And("user send the filled form")
    public void userSendTheFilledForm() {
        ReusableMethods.scrollIntoView(solliciterenPage.submit);
        solliciterenPage.submit.click();
    }

    @Then("verify that the form is sent")
    public void verify_that_the_form_is_sent() {
        ReusableMethods.waitForStaleElementVisibility(solliciterenPage.submitMessage);
        Assert.assertEquals(
                "Sollicitatie form did not submit",
                " voor je sollicitatie!",
                solliciterenPage.submitMessage.getText());

    }

    @And("user fills out the form with not valid first name {string}")
    public void userFillsOutTheFormWithNotValidFirstName(String firstName) {
    }

    @And("user fills out the form with not valid last name {string}")
    public void userFillsOutTheFormWithNotValidLastName(String lastName) {
    }

    @And("user fills out the form with not valid e-mail {string}")
    public void userFillsOutTheFormWithNotValidEMail(String e_mail) {
    }

    @And("user fills out the form with not valid Telefoonnummer {string}")
    public void userFillsOutTheFormWithNotValidTelefoonnummer(String phoneNumber) {
    }
}
