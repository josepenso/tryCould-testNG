
Feature: As a user, I should be able to access to Contacts module.


  @smokeVerifyTitle
  Scenario:  verify user access to Talks module

    Given user on the dashboard page with these "User101" and "Userpass123"
    When the user clicks the "Contacts" module
    Then verify the page title is "Contacts - Trycloud"