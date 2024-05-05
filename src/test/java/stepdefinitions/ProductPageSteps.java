package stepdefinitions;

import com.pages.*;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.*;

public class ProductPageSteps {

    private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
    private ProductsPage productsPage;

    @Given("user performs login")
    public void user_performs_login() throws InterruptedException {
        productsPage = landingPage.doLogin();
    }

    @Then("user validates product page url")
    public void user_validates_prodpage_url() throws InterruptedException {
        productsPage.validatePageUrl();
    }

    @And("user validates product page title")
    public void user_validates_prodpage_header() throws InterruptedException {
        productsPage.validatePageTitle();
    }

}
