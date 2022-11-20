Feature:As a user, I should be able to search any item/ users from the homepage.


@smoke2
  Scenario: Verify users can search any files/folder/users from the search box.


  Given user on the dashboard page with these "<username>" and "<password>"
    When the user clicks the magnifier icon on the right top
    And users search any existing file,folder,username
    Then verify the app displays the expected result option

