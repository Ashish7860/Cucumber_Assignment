package com.nagarro.cucumber.runners;

import io.cucumber.testng.CucumberOptions;  
import io.cucumber.testng.AbstractTestNGCucumberTests; 


@CucumberOptions(
	    features = "src/test/resources/features", // Path to your feature files
	    glue = {"com.nagarro.cucumber.stepdefinitions"} 
	    //tags = "@login1"
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	}
