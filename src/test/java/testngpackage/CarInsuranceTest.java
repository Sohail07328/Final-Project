package testngpackage;

import org.testng.annotations.*;
import org.testng.Assert;
import base.BaseBrowserSetup;
import main.CarInsurance_Page;

public class CarInsuranceTest extends BaseBrowserSetup {

    private CarInsurance_Page carPage;

    @BeforeClass
    public void setUp() {
        initializeBrowser("edge");
    }

    @BeforeMethod
    public void methodSetup() {
        carPage = new CarInsurance_Page(driver);
    }

    @Test(description = "Verify error message appears for invalid mobile number input")
    public void verifyErrorMessageForInvalidMobileNumber() {
        carPage.navigateToCarInsurance();
        carPage.proceedWithoutCarNumber();
        carPage.selectCity();
        carPage.selectBrand();
        carPage.selectModel();
        carPage.selectFuelType();
        carPage.selectVariant();
        carPage.enterUserDetails("John Doe", "874654372"); // Invalid number

        String error = carPage.getErrorMessage();
        System.out.println("Captured Error Message: " + error);

        Assert.assertTrue(error.toLowerCase().contains("valid"), "Expected error message about invalid mobile number.");
    }

    @AfterMethod
    public void tearDownMethod() {
        carPage = null;
    }

    @AfterClass
    public void shutDown() {
        closeBrowser();
    }
}
