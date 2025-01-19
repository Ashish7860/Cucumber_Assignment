package com.nagarro.cucumber.hooks;

import com.nagarro.cucumber.utilities.Driver; // Use the custom Driver class

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
    	// Initialize the WebDriver before each test
        Driver.getDriver(); 
    }

    @After
    public void tearDown() {
    	// Quit the WebDriver after each test
        Driver.quitDriver(); 
    }
}
