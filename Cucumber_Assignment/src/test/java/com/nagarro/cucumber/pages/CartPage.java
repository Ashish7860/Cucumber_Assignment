package com.nagarro.cucumber.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage {

    private WebDriver driver;
    
    // Locator for the cart icon
    @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
    private WebElement cartIcon;

    // Constructor to initialize elements
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on the cart icon
    public void clickCartIcon() {
        cartIcon.click();
    }
    
    public void openCartPage() {
        driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");  
    }

    
    private void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
