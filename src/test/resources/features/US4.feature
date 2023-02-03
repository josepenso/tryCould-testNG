
Feature: As a user, I should be able to access to Files module.


  @smoke @firefox
  Scenario: verify users can access to Files module

    Given user on the dashboard page with these "User32" and "Userpass123"
    When the user clicks the "Files" module
    Then verify the page title is "Files - Trycloud"




  @smoke
  Scenario: verify users can select all the uploaded files from the page

    Given user on the dashboard page with these "User65" and "Userpass123"
    When the user clicks the "Files" module
    And user click the top-left checkbox of the table
    Then verify all the files are selected
