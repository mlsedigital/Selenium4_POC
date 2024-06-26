package stepdefinitions;

import com.pages.LandingPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;

public class LandingPageSteps {

    private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());

    @Test(priority = 1)
    @Given("user navigates to homepage")
    public void user_navigates_to_homepage() throws InterruptedException {
        landingPage.validatePageUrl();
    }

    @Test(priority = 2)
    @And("user validates the landing page header")
    public void user_validates_page_header() throws InterruptedException {
        landingPage.validatePageTitle();
    }

}