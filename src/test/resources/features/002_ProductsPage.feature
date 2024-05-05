Feature: Verify products page functionality

  Background: Open browser and navigate to the landing page
    Given user navigates to homepage
    And user validates the landing page header

  Scenario: User logs in and navigates to products page
    Given user performs login
    Then user validates product page url
    And user validates product page title