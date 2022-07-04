Feature: users should be able to log out


  @UND-1127
  Scenario: users should able to log out
    Given Users logged in page with valid credentials
    When users click on user's profile button
    And users click on logout button
    Then verify that users can log out

  @UND-1128
  Scenario: users should able to log out and can not login by clicking step back
    Given Users logged in page with valid credentials
    When users click on user's profile button
    And users click on logout button
    Then verify that users can log out
    Then verify that users can not login with clicking step back
    Then verify that users shouldn't be able to login


