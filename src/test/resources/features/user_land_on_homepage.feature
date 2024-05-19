Feature: User navigates to the homepage and accept cookies

  Scenario: User navigates to the homepage and accept cookies
    Given user is on the homepage
    When user clicks on accept cookies
    Then car search section is displayed