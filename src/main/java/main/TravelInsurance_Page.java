package main;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurance_Page {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public TravelInsurance_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

  
    @FindBy(xpath = "/html/body/main/div[2]/section/div[7]/a/div[1]/p")
    WebElement travelInsuranceLink;

    @FindBy(id = "country")
    WebElement countryInput;

    @FindBy(xpath = "//*[@id=\"search-country\"]/ul")
    WebElement countryDropdown;

    @FindBy(xpath = "//div[@class='newPq_duration_wrap__dateCol'][1]")
    WebElement datePicker;

    @FindBy(xpath = "//button[@aria-label ='Aug 1, 2025']")
    WebElement startDate;

    @FindBy(xpath = "//button[@aria-label ='Aug 20, 2025']")
    WebElement endDate;

    @FindBy(xpath = "//button[@class='travel_main_cta' and text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "/html/body/section[2]/section/article/div/div/div[2]/div[1]/div[1]/div[2]/label")
    WebElement twoTravellerOption;

    @FindBy(id = "0")
    WebElement ageDropdown1;

    @FindBy(xpath = "//label[@for='21 years_undefined']")
    WebElement age21;

    @FindBy(id = "1")
    WebElement ageDropdown2;

    @FindBy(xpath = "//label[@for='22 years_undefined']")
    WebElement age22;

    @FindBy(id = "ped_no")
    WebElement noPreExistingDisease;

    @FindBy(xpath = "//*[@id=\"modal-root\"]/section/article/div/div/div[2]/div[3]/div/button")
    WebElement proceedButton;

    @FindBy(xpath = "//button[@class='travel_main_cta']")
    WebElement viewPlansButton;

    
    private void highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    private void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    private void waitAndClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            scrollToElement(element);
            highlightElement(element);
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, trying JS click.");
            jsClick(element);
        }
    }

    private void waitAndSendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        highlightElement(element);
        element.clear();
        element.sendKeys(text);
    }

    
    public void clickTravelInsuranceLink() {
        waitAndClick(travelInsuranceLink);
        System.out.println("Clicked on Travel Insurance link.");
    }

    public void enterCountry(String countryName) {
        waitAndClick(countryInput);
        waitAndSendKeys(countryInput, countryName);
        waitAndClick(countryDropdown);
        System.out.println("Entered country and selected from dropdown.");
    }

    public void selectTravelDates() {
        waitAndClick(datePicker);
        waitAndClick(startDate);
        waitAndClick(endDate);
        System.out.println("Selected travel dates.");
    }

    public void clickContinueButton() {
        waitAndClick(continueButton);
        System.out.println("Clicked Continue button.");
    }

    public void selectTravellersAndAges() {
        waitAndClick(twoTravellerOption);
        waitAndClick(ageDropdown1);
        waitAndClick(age21);
        waitAndClick(ageDropdown2);
        waitAndClick(age22);
        System.out.println("Selected travellers and their ages.");
    }

    public void selectPreExistingCondition() {
        waitAndClick(noPreExistingDisease);
        waitAndClick(proceedButton);
        System.out.println("Selected pre-existing condition and clicked Proceed.");
    }

    public void viewPlans() {
        waitAndClick(viewPlansButton);
        System.out.println("Clicked View Plans button.");
    }
}
