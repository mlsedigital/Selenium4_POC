package stepdefinitions;

import com.pages.*;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.*;
import io.cucumber.java.ja.且つ;
import org.testng.annotations.Test;

public class ProductPageSteps {

    private LandingPage landingPage = new LandingPage (DriverFactory.getDriver());
    private ProductsPage productsPage;

    @Test(priority = 1)
    @Given("user logs in")
    public void user_logs_in() {
        productsPage = landingPage.doLogin();
    }

    @Test(priority = 2)
    @Given("user validates product page url")
    public void user_validates_prodpage_url() throws InterruptedException {
        productsPage.validatePageUrl();
    }

    @Test(priority = 3)
    @And("user validates product page title")
    public void user_validates_prodpage_header() throws InterruptedException {
        productsPage.validatePageTitle();
    }

}
