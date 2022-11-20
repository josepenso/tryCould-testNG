Feature: As a user, I should be able to access to Files module - Favorites button


  @ui
  Scenario: Verify users to add files to Favorites

    Given user on the dashboard page with these "User50" and "Userpass123"
    When the user clicks the "Files" module
    When the user clicks action-icon from any file on the page and choose the "Add to favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify the chosen file is listed on the table