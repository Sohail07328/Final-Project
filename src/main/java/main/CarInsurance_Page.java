package main;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CarInsurance_Page {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public CarInsurance_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "/html/body/main/div[2]/section/div[4]/a/div[1]/div")
    private WebElement carInsuranceLink;

    @FindBy(xpath = "//span[@class='CarRegDetails_blueTextButton__P1blP blueTextButton fontMedium']")
    private WebElement proceedWithoutCarNumber;

    @FindBy(xpath = "//span[@class='truncate' and text()='Bangalore']")
    private WebElement citySelect;

    @FindBy(xpath = "//li[@class='mahindra ']")
    private WebElement brandSelect;

    @FindBy(xpath = "/html/body/section/section/div/div/div/div[2]/div[2]/div[3]/ul/li[1]")
    private WebElement modelSelect;

    @FindBy(xpath = "/html/body/section/section/div/div/div/div[2]/div[2]/div/ul/li[1]")
    private WebElement fuelTypeSelect;

    @FindBy(xpath = "/html/body/section/section/div/div/div/div[2]/div[2]/div[3]/ul/li[1]")
    private WebElement variantSelect;

    @FindBy(xpath = "//input[@id='name-form-control']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='mobile-form-control']")
    private WebElement mobileField;

    @FindBy(xpath = "//div[@class='errorMsg']")
    private WebElement errorMsg;

    private void waitForPageLoad() {
        wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
    }

    private void highlightElement(WebElement element) {
        try {
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        } catch (StaleElementReferenceException e) {
            System.out.println("Skipping highlight due to stale element: " + e.getMessage());
        }
    }

    private void waitForElementToBeReady(WebElement element) {
        int retries = 3;
        while (retries > 0) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            } catch (StaleElementReferenceException e) {
                retries--;
                System.out.println("Retrying due to stale element: " + e.getMessage());
            }
        }
    }

    private void clickElement(WebElement element) {
        waitForElementToBeReady(element);
        highlightElement(element);
        element.click();
    }

    private void enterText(WebElement element, String text) {
        waitForElementToBeReady(element);
        highlightElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void navigateToCarInsurance() {
        waitForPageLoad();
        clickElement(carInsuranceLink);
    }

    public void proceedWithoutCarNumber() {
        clickElement(proceedWithoutCarNumber);
    }

    public void selectCity() {
        clickElement(citySelect);
    }

    public void selectBrand() {
        clickElement(brandSelect);
    }

    public void selectModel() {
        clickElement(modelSelect);
    }

    public void selectFuelType() {
        clickElement(fuelTypeSelect);
    }

    public void selectVariant() {
        clickElement(variantSelect);
    }

    public void enterUserDetails(String name, String mobile) {
        enterText(nameField, name);
        enterText(mobileField, mobile);
    }

    public String getErrorMessage() {
        waitForElementToBeReady(errorMsg);
        highlightElement(errorMsg);
        return errorMsg.getText();
    }
}
