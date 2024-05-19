Feature: User logs in

  Background:
    Given user is on the homepage

#negative
  Scenario: User logs in with invalid credentials

    When user tries to log in with invalid credentials
    Then error message is displayed

#positive
  Scenario: User logs in with valid credentials
    When user tries to log in with valid credentials
    Then user logged in successfully

