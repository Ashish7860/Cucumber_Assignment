package com.nagarro.cucumber.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nagarro.cucumber.utilities.Driver;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");

    public void enterSearchTerm(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
