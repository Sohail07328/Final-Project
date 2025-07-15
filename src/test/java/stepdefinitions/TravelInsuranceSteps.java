package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.By; // Added for element presence check
import org.openqa.selenium.NoSuchElementException; // Added for element presence check
import org.openqa.selenium.TimeoutException; // Added for element presence check
import org.openqa.selenium.support.ui.ExpectedConditions; // Added for explicit waits

import base.BaseBrowserSetup;
import main.TravelInsurance_Page;

public class TravelInsuranceSteps {

    private WebDriver driver;
    private TravelInsurance_Page insurancePage;
    private BaseBrowserSetup baseSetup;

    @Before("@TravelInsurance")
    public void setupTravelScenario() {
        baseSetup = new BaseBrowserSetup();
        baseSetup.initializeBrowser("chrome");
        this.driver = baseSetup.driver;
        insurancePage = new TravelInsurance_Page(driver);
    }

    @After("@TravelInsurance")
    public void tearDownTravelScenario() {
        if (baseSetup != null) {
            baseSetup.closeBrowser();
        }
    }

    @Given("I am on the Policybazaar website")
    public void i_am_on_the_policybazaar_website() {
        System.out.println("Navigated to Policybazaar website via @Before hook.");
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkName) {
        if (linkName.equalsIgnoreCase("Travel Insurance")) {
            insurancePage.clickTravelInsuranceLink();
        } else {
            throw new IllegalArgumentException("Unsupported link name: " + linkName);
        }
    }

    @And("I enter destination country as {string}")
    public void i_enter_destination_country_as(String countryName) {
        insurancePage.enterCountry(countryName);
    }

    @And("I select travel dates")
    public void i_select_travel_dates() {
        insurancePage.selectTravelDates();
    }

    @And("I click on the continue button")
    public void i_click_on_the_continue_button() {
        insurancePage.clickContinueButton();
    }

    @And("I select travellers and their ages")
    public void i_select_travellers_and_their_ages() {
        insurancePage.selectTravellersAndAges();
    }

    @And("I select pre-existing medical condition status")
    public void i_select_pre_existing_medical_condition_status() {
        insurancePage.selectPreExistingCondition();
    }
}