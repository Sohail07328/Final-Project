package testngpackage;

import org.testng.annotations.*;
import org.testng.Assert;
import base.BaseBrowserSetup;
import main.MedicalInsurancePage;

import java.util.List;

public class MedicalInsuranceTest extends BaseBrowserSetup {
    MedicalInsurancePage page;

    @BeforeClass
    public void setUp() {
        initializeBrowser("chrome");
    }

    @BeforeMethod
    public void methodSetup() {
        page = new MedicalInsurancePage(driver);
    }

    @Test
    public void testMedicalInsuranceOptions() {
        page.clickViewAllProducts();
        List<String> options = page.fetchMedicalInsuranceOptions();

        System.out.println("Medical Insurance Options:");
        for (String option : options) {
            System.out.println(option);
        }

        Assert.assertTrue(options.size() > 0, "No medical insurance options found!");
    }

    @AfterMethod
    public void tearDownMethod() {
        page = null;
    }

    @AfterClass
    public void shutDown() {
        closeBrowser();
    }
}
