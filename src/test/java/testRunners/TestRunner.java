package testRunners;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

import java.util.Properties;

import static io.cucumber.junit.platform.engine.Constants.*;


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

    @FindBy(id="login-button")
    private WebElement BTN_Login;

    @FindBy(id="user-name")
    private WebElement ENTER_Username;

    @FindBy(id="password")
    private WebElement ENTER_Passwd;


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

    /*
    @BeforeTest(dependsOnMethods = {"initializeBrowser"})
    public void loginApp(){
        String username=prop.getProperty("LoginId");
        String password=prop.getProperty("Passwd");
        ENTER_Username.sendKeys(username);
        ENTER_Passwd.sendKeys(password);
        BTN_Login.click();
    }*/


    @AfterTest
    public void quitDriver(){
        if (driver != null) {
            driver.quit();
        }
    }

}

/*
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, " +
        "json:target/JsonReports/cucumber.json, " +
        "html:target/HTMLReports/cucumber.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions, hooks")


public class TestRunner extends AbstractTestNGCucumberTests {


}
*/