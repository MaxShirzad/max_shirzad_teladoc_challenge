
Feature:As Engr. Candidate I need to automate xyz, so I can show my awesome automation skills

  @wip
  Scenario: Add a user and validate the user has been added to the table
    Given admin is on the page
    When  admin adding a new user
    Then  admin validating the new user has been added to the table



  Scenario: Delete user User Name: novak and validate user has been deleted

    Given admin is on the page
    When  admin deleting user User Name: "novak"
    Then  admin validating the user "novak" has been deleted




