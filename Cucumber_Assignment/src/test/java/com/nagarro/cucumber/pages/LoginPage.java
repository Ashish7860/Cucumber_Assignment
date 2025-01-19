package com.nagarro.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // PageFactory elements initialization
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement accountandLists;

    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
    private WebElement signInClick;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInSubmitButton;

    @FindBy(xpath = "//span[@class='a-list-item' and contains(text(), 'Your password is incorrect')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement loggedInAccountName;

    // Constructor to initialize the driver and page elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Method to hover over 'Account and Lists'
    public void hoverAccountandList() {
        wait.until(ExpectedConditions.visibilityOf(accountandLists));
        new Actions(driver).moveToElement(accountandLists).perform();
    }

    // Method to click 'Sign in'
    public void signIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInClick));
        signInClick.click();
    }

    // Method to enter email
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    // Method to click 'Continue'
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    // Method to enter password
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    // Method to click 'Sign in' after entering credentials
    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInSubmitButton));
        signInSubmitButton.click();
    }

    // Method to verify if the user is logged in
    public boolean isAccountLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loggedInAccountName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to verify if an error message is displayed
    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
