package com.nagarro.cucumber.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import com.nagarro.cucumber.utilities.Driver;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

public class HomeStepDefinition {

    private WebDriver driver;
    private WebDriverWait wait;
    

    // Setup WebDriver before each scenario
    @Before
    public void setup() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Step to open Amazon homepage
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        driver.get("https://www.amazon.in/");
    }

    // Step to perform a search with a given search term
    @When("the user searches for {string}")
    public void the_user_searches_for(String searchTerm) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.clear();
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    // Step to verify the search results contain the search term
    @Then("the search results page should display relevant results for {string}")
    public void the_search_results_page_should_display_relevant_results_for(String searchTerm) {
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        assertTrue(results.getText().contains(searchTerm));
    }

    // Step to search with an empty string
    @When("the user searches with an empty string")
    public void the_user_searches_with_an_empty_string() {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.clear();
        searchBox.submit();
    }

    // Step to verify error handling or staying on the homepage
    @Then("an error message should be displayed or the page should remain on the homepage")
    public void an_error_message_should_be_displayed_or_the_page_should_remain_on_the_homepage() {
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
            assertTrue(errorMessage.isDisplayed());
        } catch (Exception e) {
            assertTrue(driver.getCurrentUrl().equals("https://www.amazon.in/"));
        }
    }

    // Step to search with special characters
    @When("the user searches for {string} with special characters")
    public void the_user_searches_for_with_special_characters(String specialChars) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.clear();
        searchBox.sendKeys(specialChars);
        searchBox.submit();
    }

    // Step to handle special characters gracefully and verify the search result
    @Then("the search results page should handle the search gracefully and display no results or a default message")
    public void the_search_results_page_should_handle_the_search_gracefully_and_display_no_results_or_a_default_message() {
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        assertTrue(results.getText().isEmpty() || results.getText().contains("No results found"));
    }

    // Tear down the WebDriver session after each scenario
    @After
    public void teardown() {
        Driver.quitDriver();
    }
}
