package testRunners;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;
import java.util.Properties;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},

        glue = { "stepdefinitions", "hooks" },

        dryRun = false,

        plugin = { "pretty",
                "json:target/JsonReports/cucumber.json",
                "html:target/HTMLReports/cucumber.html" }

)

public class TestRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;
    private DriverFactory driverFactory;
    private ConfigReader configReader;
    static Properties prop;


    @BeforeSuite
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Parameters("browserName")
    @BeforeTest
    public void initializeBrowser(String bName) throws InterruptedException {

        System.out.println("Hooks - initializeBrowser");
        System.out.println("TestNG browser: " +bName);
        String url = prop.getProperty("url");
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(bName);
        driver.navigate().to(url);
    }


    @AfterTest
    public void quitDriver(){
        if (driver != null) {
            driver.quit();
        }
    }

}