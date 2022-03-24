package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SolliciterenPage;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class SolliciterenStepdef extends SolliciterenPage {

    @And("I am on the Cloud Engineer job application form")
    public void iAmOnTheCloudEngineerJobApplicationForm() {
        ReusableMethods.hover(menu);
        ReusableMethods.waitForStaleElementVisibility(cloudEngineer);
        ReusableMethods.clickWithJS(cloudEngineer);

        ReusableMethods.waitForStaleElementVisibility(apply);
        ReusableMethods.clickWithJS(apply);
    }

    @And("I want to apply for Cloud Engineer position {string}")
    public void iWantToApplyForCloudEngineerPositionTest_case(String testCase) {
        System.out.println(testCase);
    }

    @When("I send following attributes to apply for the Cloud Engineer position:")
    public void iSendFollowingAttributesToApplyForTheCloudEngineerPosition(List<Map<String, String>> formDt) {
        Map<String, String> userInfo = formDt.get(0);

        firstName.sendKeys(userInfo.get("firstName"));
        lastName.sendKeys(userInfo.get("lastName"));
        e_mail.sendKeys(userInfo.get("e-mail"));
        phoneNumber.sendKeys(userInfo.get("telefoonNummer"));

        ReusableMethods.waitForStaleElementVisibility(submit);
        ReusableMethods.clickWithJS(submit);
    }

    @Then("I should see {string} on the page")
    public void iShouldSeeMessageOnThePage(String expectedText) {
        boolean isVisible = ReusableMethods.isVisible(getElementWithText(expectedText));
        Assert.assertTrue("Sollicitatie form did not submit, couldn't find message: " + expectedText,
                isVisible
        );
    }
}
