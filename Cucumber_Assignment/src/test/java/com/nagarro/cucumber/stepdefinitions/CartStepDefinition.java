package com.nagarro.cucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.nagarro.cucumber.pages.CartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import static org.junit.Assert.assertTrue;
import com.nagarro.cucumber.utilities.Driver;

public class CartStepDefinition {

    WebDriver driver;
    CartPage cartPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();  // Initialize WebDriver
        cartPage = new CartPage(driver);  // Initialize CartPage
    }

    // Step: User is on the cart page
    @Given("the user is on the cart page")
    public void the_user_is_on_the_cart_page() {
        cartPage.openCartPage();  
    }

    // Step: User clicks on the cart icon
    @When("the user clicks on the cart icon")
    public void the_user_clicks_on_the_cart_icon() {
        cartPage.clickCartIcon();
    }

    @Then("the user should be redirected to the cart page")
    public void the_user_should_be_redirected_to_the_cart_page() {
        assertTrue(driver.getCurrentUrl().contains("cart"));  
    }

    @After
    public void teardown() {
        Driver.quitDriver(); 
    }
}
