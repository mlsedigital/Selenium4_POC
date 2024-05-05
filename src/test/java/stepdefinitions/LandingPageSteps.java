package stepdefinitions;

import com.pages.LandingPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LandingPageSteps {

    private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());

    @Given("user is able to navigate to homepage")
    public void user_navigates_to_homepage() throws InterruptedException {
        landingPage.validatePageUrl();
    }

    @And("user is able to validate the landing page header")
    public void user_validates_page_header() throws InterruptedException {
        landingPage.validatePageTitle();
    }

}
