package com.nagarro.cucumber.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    private static WebDriver driver;
    
    // Method to get WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Method to quit WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver
        }
    }
}
