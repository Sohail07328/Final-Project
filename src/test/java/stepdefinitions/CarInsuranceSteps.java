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
import main.CarInsurance_Page; 

public class CarInsuranceSteps {

    private WebDriver driver;
    private CarInsurance_Page carPage;
    private BaseBrowserSetup baseSetup; 

    @Before
    public void setupScenario() {
        baseSetup = new BaseBrowserSetup(); 
        baseSetup.initializeBrowser("chrome");
        this.driver = baseSetup.driver;
        carPage = new CarInsurance_Page(driver); 
    }

    
    @After
    public void tearDownScenario() {
        if (baseSetup != null) {
            baseSetup.closeBrowser();
        }
    }

    @Given("I am on the Policybazaar Car Insurance page")
    public void i_am_on_the_policybazaar_car_insurance_page() {
        carPage.navigateToCarInsurance();
    }

    @When("I proceed without entering a car number")
    public void i_proceed_without_entering_a_car_number() {
        carPage.proceedWithoutCarNumber();
    }

    @And("I select the city")
    public void i_select_the_city() {
        carPage.selectCity();
    }

    @And("I select the car brand")
    public void i_select_the_car_brand() {
        carPage.selectBrand();
    }

    @And("I select the car model")
    public void i_select_the_car_model() {
        carPage.selectModel();
    }

    @And("I select the fuel type")
    public void i_select_the_fuel_type() {
        carPage.selectFuelType();
    }

    @And("I select the variant")
    public void i_select_the_variant() {
        carPage.selectVariant();
    }

    @And("I enter user details with name {string} and invalid mobile number {string}")
    public void i_enter_user_details_with_name_and_invalid_mobile_number(String name, String mobileNumber) {
        carPage.enterUserDetails(name, mobileNumber);
    }

    @Then("I should see an error message containing {string} for the mobile number field")
    public void i_should_see_an_error_message_containing_for_the_mobile_number_field(String expectedErrorPart) {
        String actualError = carPage.getErrorMessage();
        System.out.println("Captured Error Message: " + actualError);
        Assert.assertTrue(actualError.toLowerCase().contains(expectedErrorPart.toLowerCase()),
                "Expected error message to contain '" + expectedErrorPart + "' but found '" + actualError + "'");
    }
}