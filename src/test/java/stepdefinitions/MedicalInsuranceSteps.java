package stepdefinitions; 

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseBrowserSetup;
import main.MedicalInsurancePage; // Your MedicalInsurancePage POM

import java.util.List;

public class MedicalInsuranceSteps {

    private WebDriver driver;
    private MedicalInsurancePage medicalPage;
    private BaseBrowserSetup baseSetup;
    private List<String> fetchedOptions; 
    
    @Before("@MedicalInsurance")
    public void setupMedicalScenario() {
        baseSetup = new BaseBrowserSetup();
        
        baseSetup.initializeBrowser("chrome");
        this.driver = baseSetup.driver;
        medicalPage = new MedicalInsurancePage(driver);
    }

    @After("@MedicalInsurance")
    public void tearDownMedicalScenario() {
        if (baseSetup != null) {
            baseSetup.closeBrowser();
        }
    }

    @Given("I navigate to the {string} section")
    public void i_navigate_to_the_section(String sectionName) {
        if (sectionName.equalsIgnoreCase("View All Products")) {
            medicalPage.clickViewAllProducts();
        } else {
            throw new IllegalArgumentException("Unsupported section specified in Gherkin: " + sectionName);
        }
    }

    @When("I fetch the list of medical insurance options")
    public void i_fetch_the_list_of_medical_insurance_options() {
        fetchedOptions = medicalPage.fetchMedicalInsuranceOptions();
    }

    @Then("I should see more than zero medical insurance options displayed")
    public void i_should_see_more_than_zero_medical_insurance_options_displayed() {
        Assert.assertTrue(fetchedOptions != null && fetchedOptions.size() > 0,
                "Expected to find more than zero medical insurance options, but none were found or fetched.");
    }

    @And("I should print all fetched medical insurance options")
    public void i_should_print_all_fetched_medical_insurance_options() {
        System.out.println("\n--- Fetched Medical Insurance Options ---");
        if (fetchedOptions != null && !fetchedOptions.isEmpty()) {
            for (String option : fetchedOptions) {
                System.out.println("- " + option);
            }
        } else {
            System.out.println("No medical insurance options were fetched in the previous step.");
        }
        System.out.println("-----------------------------------------\n");
    }
}