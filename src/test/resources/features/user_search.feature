Feature: User perform search activity

  Background:
    Given user is on the homepage and already logged in

  Scenario: user perform search activity without specification
    When user clicks on search button
    Then user is on search page

  Scenario: user perform search activity with specification
    When user adds some specification to the search section
    And user clicks on filtered search button
    Then user is on filtered search page