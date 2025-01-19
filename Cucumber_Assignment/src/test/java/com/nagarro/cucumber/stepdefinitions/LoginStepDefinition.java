
package com.nagarro.cucumber.stepdefinitions;

import com.nagarro.cucumber.pages.LoginPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import java.time.Duration;
import io.cucumber.java.After;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nagarro.cucumber.utilities.Driver;

public class LoginStepDefinition {

    WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage; // Declare LoginPage object

    private String validUsername = "yagyasaini9453932298@gamil.com";
    private String validPassword = "kum148";

    @Before
    public void setup() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver); // Initialize LoginPage
    }

    @Given("the user is on the Amazon homepage")
    public void the_user_is_on_the_amazon_homepage() {
        driver.get("https://www.amazon.in/");
    }

    @When("the user hovers over Account and Lists")
    public void the_user_hovers_over_account_and_lists() {
        loginPage.hoverAccountandList(); // Use method from LoginPage
    }

    @When("the user clicks on Sign in")
    public void the_user_clicks_on_sign_in() {
        loginPage.signIn(); // Use method from LoginPage
    }

    @When("the user enters the email {string}")
    public void the_user_enters_the_email(String email) {
        loginPage.enterEmail(email); // Use method from LoginPage
    }

    @When("the user clicks continue")
    public void the_user_clicks_continue() {
        loginPage.clickContinue(); // Use method from LoginPage
    }

    @When("the user enters the password {string}")
    public void the_user_enters_the_password(String password) {
        loginPage.enterPassword(password); // Use method from LoginPage
    }

    @When("the user clicks on Sign in button")
    public void the_user_clicks_on_sign_in_button() {
        loginPage.clickSignIn(); // Use method from LoginPage
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        // You could add a verification method in LoginPage for this
        assertTrue(loginPage.isAccountLoggedIn()); // Assume isAccountLoggedIn() method exists in LoginPage
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        // You could add an error checking method in LoginPage
        assertTrue(loginPage.isErrorMessageDisplayed()); // Assume isErrorMessageDisplayed() exists in LoginPage
    }

    @After
    public void teardown() {
        Driver.quitDriver();
    }
}
