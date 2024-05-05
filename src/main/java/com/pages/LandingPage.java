package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LandingPage extends Config_BasePage {

    public LandingPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(id="user-name")
    private WebElement ENTER_Username;

    @FindBy(id="password")
    private WebElement ENTER_Passwd;

    @FindBy(id="login-button")
    private WebElement BTN_Login;

    public void validatePageUrl() throws InterruptedException{
        System.out.println("Page URL: " +driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    public void validatePageTitle() throws InterruptedException{
        System.out.println("Page Title: " +driver.getTitle());
        Thread.sleep(2000);
    }

    public ProductsPage doLogin(){
        ENTER_Username.sendKeys("standard_user");
        ENTER_Passwd.sendKeys("secret_sauce");
        BTN_Login.click();
        return new ProductsPage(driver);
    }

}
