Feature: User adds advertisement

  Scenario: User create advertisement successfully
    Given user is on add Advertisement page
    When user selects vehicles type
    And user fills out the form
    Then user sends the form successfully