package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:test-results/html-reports/cucumber.html",
                "json:test-results/json-reports/cucumber.json",
                "junit:test-results/xml-report/cucumber.xml",
                "rerun:test-results/failedRerun.txt"
        },
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",
        publish = true,
        dryRun = false
)
public class Runner {
}
