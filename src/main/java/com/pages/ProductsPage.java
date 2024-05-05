package com.pages;

import org.openqa.selenium.WebDriver;

public class ProductsPage extends Config_BasePage{

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

}
