package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//This is used for more readable reports or outputs
                "html:test-results/html-reports/cucumber.html",//Use this reports
                "json:test-results/json-reports/cucumber.json",
                "junit:test-results/xml-report/cucumber.xml",
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:test-results/failedRerun.txt"
        },
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",
        dryRun = false
)

public class Runner {

}
