package main;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class MedicalInsurancePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions actions;

    public MedicalInsurancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @FindBy(linkText = "View all products")
    WebElement viewAllProductsLink;

    @FindBy(xpath = "//*[@id='tab-content1']/div[1]/div[2]/ul/li")
    List<WebElement> medicalOptions;

    private void highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void clickViewAllProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllProductsLink));
        actions.moveToElement(viewAllProductsLink).perform(); // Scroll into view
        highlightElement(viewAllProductsLink);
        viewAllProductsLink.click();
        System.out.println("Clicked on 'View all products'.");
    }

    public List<String> fetchMedicalInsuranceOptions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(medicalOptions));
        List<String> options = new ArrayList<>();
        for (WebElement option : medicalOptions) {
            highlightElement(option);
            options.add(option.getText());
        }
        return options;
    }
}
