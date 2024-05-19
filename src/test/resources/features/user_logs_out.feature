Feature: User logs out

  Scenario: User perform log out
    Given logged in user is on the home page
    When user clicks on log out button
    Then user logged out successfully