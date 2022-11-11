
Feature: As a user, I should be able to log in.


      Background:
            Given user on the login page

 @demo
     Scenario Outline: Verify login with valid credentials

    When user types username "<username>" and password "<password>"
    And user click the login button
    Then verify the user should be at the dashboard "<title>" page

    Examples:
      | username    | password    |  title                |
      | user7       | Userpass123 |Dashboard - Trycloud   |
      | user34      | Userpass123 |Dashboard - Trycloud   |
      | user99      | Userpass123 |Dashboard - Trycloud   |


  @ui
      Scenario Outline: Verify user login fail with invalid credentials

        When user enter invalid username "<username>" and  password "<password>"
        And user click the login Button
        Then verify "<message>" message should be displayed
        Examples:
          | username  |   password        | message                     |
          | User9        |   Wrong        | Wrong username or password. |
          | Wrong        |   Userpass123  | Wrong username or password  |
          | Wrong        |     Wrong      | Wrong username or password. |