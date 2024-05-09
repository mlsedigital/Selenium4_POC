package hooks;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Properties;

public class ApplicationHooks {

    private WebDriver driver;
    //private DriverFactory driverFactory;
    //private ConfigReader configReader;
    Properties prop;
    String home_dir = System.getProperty("user.home");

    /*
    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void initializeBrowser() throws InterruptedException {

        System.out.println("Hooks - initializeBrowser");
        String url = prop.getProperty("url");
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
        driver.navigate().to(url);
    }*/



    // Quit Driver instance
    /*
    @After(order = 0)
    public void quitDriver(){
        if (driver != null) {
            driver.quit();
        }
    }*/


    // Capture screenshot for reporting purposes for the failed tests
    @After(order = 1)
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed() && driver != null) {
            // To Take Screenshot for Failed Test cases
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

            //Give a filename to screenshot and save it to target
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = localDateTime.toLocalDate();
            LocalTime localTime = localDateTime.toLocalTime();
            String sc_path = "target/Screenshots/";
            String sc_Name = (localDate.toString()) + "T" + (localTime.toString());
            String sc_final_Path = sc_path + sc_Name + ".jpeg";

            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot =((TakesScreenshot)driver); //Call getScreenshotAs method to create image file
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);


            //Move image file to new destination
            File DestFile=new File(sc_final_Path); //Copy file at destination

            try {
                FileUtils.copyFile(SrcFile, DestFile);
            } catch (IOException e){
                e.printStackTrace();
            }


        }

    }

}
