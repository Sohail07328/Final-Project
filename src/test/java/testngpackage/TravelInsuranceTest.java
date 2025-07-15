package testngpackage;

import org.testng.annotations.*;
import org.testng.Assert;
import base.BaseBrowserSetup;
import main.TravelInsurance_Page;

public class TravelInsuranceTest extends BaseBrowserSetup {

    TravelInsurance_Page insurancePage;

    @BeforeClass
    public void setUp() {
        initializeBrowser("chrome");
    }

    @BeforeMethod
    public void initPage() {
        insurancePage = new TravelInsurance_Page(driver);
    }

    @Test
    public void testTravelInsuranceFlowStepByStep() throws InterruptedException {
        insurancePage.clickTravelInsuranceLink();
        insurancePage.enterCountry("France");
        insurancePage.selectTravelDates();
        insurancePage.clickContinueButton();
        insurancePage.selectTravellersAndAges();
        insurancePage.selectPreExistingCondition();
        insurancePage.viewPlans();

        Assert.assertNotNull(insurancePage, "Travel insurance page object is null.");
        System.out.println("All steps executed successfully.");
    }

    @AfterMethod
    public void tearDownMethod() {
        insurancePage = null;
    }

    @AfterClass
    public void shutDown() {
        closeBrowser();
    }
}
