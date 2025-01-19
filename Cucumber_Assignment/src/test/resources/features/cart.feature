
Feature: Cart functionality

  Scenario: User clicks on the cart icon
    Given the user is on the Amazon homepage
    When the user clicks on the cart icon
    Then the user should be redirected to the cart page

