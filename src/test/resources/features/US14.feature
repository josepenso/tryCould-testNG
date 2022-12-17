Feature:As a user, I should be able to search any item/ users from the homepage.


  @smoke
  Scenario: Verify users can search any files/folder/users from the search box.


  Given user on the dashboard page with these "User64" and "Userpass123"
    When the user clicks the magnifier icon on the right top
    And users search any existing file,folder,username
    Then verify the app displays the expected result option

