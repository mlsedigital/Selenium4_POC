package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LandingPage extends BasePage{

    public LandingPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(id="user-name")
    private WebElement username;

    public void validatePageUrl() throws InterruptedException{
        System.out.println("Page URL: " +driver.getTitle());
        Thread.sleep(2000);
    }

    public void validatePageTitle() throws InterruptedException{
        username.sendKeys("standard_user");
        Thread.sleep(2000);
    }

}
