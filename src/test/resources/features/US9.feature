Feature: As a user, I should be able to write comments to files/folders.


  @smoke
  Scenario: Verify users to write comments to files/folder

    Given user on the dashboard page with these "<username>" and "<password>"
    When the user clicks the "Files" module
    And user click "Actions"-icon  from any file on the page
    And user choose the "Details" option
    And user write a "Comments" inside the input box
    And user click the submit button to post it
    Then Verify the comment is displayed in the comment section.