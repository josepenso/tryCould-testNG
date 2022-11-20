Feature: As a user, I should be able to remove files from favorites and upload a file directly




  @ui
  Scenario: verify users to remove files to Favorites

    Given user on the dashboard page with these "User50" and "Userpass123"
    When the user clicks the "Files" module
    When user click "Actions"-icon  from any file on the page
    When the user clicks action-icon from any file on the page and choose the "Remove from favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify that the file is removed from the Favorites sub-module’s table



  #Need to figure out how to delete file after upload it
  Scenario: verify users to upload a file from Files
    Given user on the dashboard page with these "User59" and "Userpass123"
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users uploads file with the "Upload file" option
    Then verify the file is displayed on the page