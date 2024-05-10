package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Config_BasePage {
    WebDriver driver;

    public Config_BasePage(WebDriver driver) {
        System.out.println("Redirected from Hooks to Config_BasePage");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
