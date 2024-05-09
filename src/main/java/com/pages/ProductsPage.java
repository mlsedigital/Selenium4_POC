package com.pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends Config_BasePage{

    @FindBy(css="a.shopping_cart_link")
    private WebElement LOGO_Cart;

    public ProductsPage (WebDriver driver) {
        super(driver);
    }

    public void validatePageUrl() throws InterruptedException{
        System.out.println("Product Page URL: " +driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    public void validatePageTitle() throws InterruptedException{
        System.out.println("Product Page Title: " +driver.getTitle());
        Thread.sleep(2000);
    }

    public CartPage navigateToCart(){
        LOGO_Cart.click();
        return new CartPage(driver);
    }

}
