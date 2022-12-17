
Feature: As a user, I should be able to access to Talks module


    Story: As a user, I should be able to access to Talks module.
    Background:
      Given user on the dashboard page with these "User64" and "Userpass123"
      When the user clicks the "Talk" module

  Scenario: verify users to access to Talks module

    Then verify the page title is "Talk - Trycloud"



  @smoke
  Scenario: verify users to send a message

    And user search user from the search box
    And user write a message
    And user clicks to submit button
    Then the user should be able to see the message is displayed on the conversation log