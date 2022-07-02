
Feature: As a user, I should be able to login symund main page


  Scenario: User can login with valid credentials
    Given user navigates to the symund login page
    When user leaves "Employee71" in username
    And user leaves "Employee123" in password
    And user clicks login button
    Then verify that user can login

  Scenario Outline: User can not login with any invalid credentials (wrong and blank)
    Given user navigates to the symund login page
    When user leaves "<username>" in username
    And user leaves "<password>" in password
    And user clicks login button
    Then verify that user cannot login with invalid credentials

    Examples:
      | username   | password    |
      | EmploYee71 | Employee123 |
      | Employee71 | EmplYee123  |
      | mploye71   | Employee123 |
      | Employee71 | asd123      |
      |            | Employee123 |
      |Employee71  |             |


  Scenario: User can see the password in a form of dots by default
    Given user navigates to the symund login page
    When user leaves "Employee71" in username
    And user leaves "Employee123" in password
    Then verify that user sees the password in a form of dots by default


  Scenario: User can see the password explicitly if needed
    Given user navigates to the symund login page
    When user leaves "Employee71" in username
    And user leaves "Employee123" in password
    And user clicks button that shows password
    Then verify that user can see password

  Scenario: user can navigate forgot password and reset the password
    Given user navigates to the symund login page
    When user leaves "Employee71" in username
    And user leaves "Employee123" in password
    And user clicks forgot password button
    And user leaves "email" in mail input
    Then verify that user can reset the password

  Scenario: User can see valid placeholders on Username and Password fields
    Given user navigates to the symund login page
    Then verify that "Username or email" as default in username placeholder
    Then verify that "Password" as default in password placeholder


