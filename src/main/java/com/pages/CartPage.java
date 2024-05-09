package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class CartPage extends Config_BasePage{


    @FindBy(xpath="//span[contains(text(), 'Your Cart')]")
    private WebElement TEXT_YourCart;

    @FindBy(xpath = "//button[contains(text(), 'Open Menu')]")
    private WebElement MENU_OpenMenu;

    @FindBy(xpath = "//a[contains(text(), 'All Items')]")
    private WebElement OPTION_AllItems;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void validatePageUrl() throws InterruptedException{
        System.out.println("Cart Page URL: " +driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    public void validateYourCart() {
        assertTrue(TEXT_YourCart.isDisplayed());
        System.out.println("YOUR Cart");
    }

    public ProductsPage productsPage() {
        MENU_OpenMenu.click();
        OPTION_AllItems.click();
        return new ProductsPage(driver);
    }

}
