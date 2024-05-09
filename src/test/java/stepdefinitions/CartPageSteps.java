package stepdefinitions;

import com.pages.*;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.annotations.Test;

public class CartPageSteps {

    private ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());;
    private CartPage cartPage;

    @Test(priority = 1)
    @Given("user clicks cart logo")
    public void user_clicks_cart() throws InterruptedException {
        cartPage = productsPage.navigateToCart();
    }

    @Test(priority = 2)
    @Given("user navigates to cart page")
    public void user_navigates_cartPage() throws InterruptedException {
        cartPage.validateYourCart();
    }

    @Test(priority = 3)
    @And("user validates the cart page url")
    public void user_validates_cartpage_url() throws InterruptedException {
        cartPage.validatePageUrl();
    }

}
