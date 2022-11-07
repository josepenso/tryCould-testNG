
    Feature: As a user, I should be able to log in.

@ui @smoke
  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user types username "<username>" and password "<password>"
    And user click the login button
    Then verify the user should be at the dashboard "<title>" page

    Examples:
      | username    | password    |  title                |
      | user7       | Userpass123 |Dashboard - Trycloud QA|
      | user34      | Userpass123 |Dashboard - Trycloud QA|
      | user99      | Userpass123 |Dashboard - Trycloud QA|