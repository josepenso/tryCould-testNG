

Feature: As a user, I should be able to view the contact list.


@smoke2
Scenario:  verify users can see all the contact names on the contact list

  Given user on the dashboard page with these "<username>" and "<password>"
   When the user clicks the "Contacts" module
   Then verify the contact names are in the list