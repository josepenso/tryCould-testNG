

Feature: As a user, I should be able to view the contact list.


  @smoke
Scenario:  verify users can see all the contact names on the contact list

  Given user on the dashboard page with these "User39" and "Userpass123"
   When the user clicks the "Contacts" module
   Then verify the contact names are in the list