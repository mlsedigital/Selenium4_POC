package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browserName) {

        switch (browserName.toLowerCase()) {
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;

            case "safari":
                tlDriver.set(new SafariDriver());
                break;

            case "firefox":
                //tlDriver.set(new EdgeDriver());
                tlDriver.set(new FirefoxDriver());
                break;

            default:
                tlDriver.set(new ChromeDriver());
                break;
        }
        System.out.println("DriverFactory getDriver");
        return getDriver();

    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

}
