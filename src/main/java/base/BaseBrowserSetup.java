package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseBrowserSetup {
    public WebDriver driver;

    public void initializeBrowser(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        driver.manage().window().maximize();
        driver.get("https://www.policybazaar.com");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
