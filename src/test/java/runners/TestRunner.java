package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features", 
    glue = {"stepdefinitions"}, 
    plugin = {
        "pretty", 
        "html:target/cucumber-reports/cucumber-html-report.html", 
        "json:target/cucumber-reports/cucumber.json",
        "rerun:target/failed_scenarios.txt", 
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
    },
    monochrome = true, 
    dryRun = false, 
    tags = "@Regression" 
                         
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
}