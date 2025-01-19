@login1
Feature: Amazon login functionality

  @login
  Scenario: Successful login with valid credentials
    Given the user is on the Amazon homepage
    When the user hovers over Account and Lists
    And the user clicks on Sign in
    And the user enters the email "yagyasaini9453932298@gmail.com"
    And the user clicks continue
    And the user enters the password "kum148"
    And the user clicks on Sign in button
    Then the user should be logged in successfully

  @invalidLogin
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the Amazon homepage
    When the user hovers over Account and Lists
    And the user clicks on Sign in
    And the user enters the email "yagyasaini9453932298@gmail.com"
    And the user clicks continue
    And the user enters the password "wrongPassword"
    And the user clicks on Sign in button
    Then an error message should be displayed
