Feature: Calculator UI Test

  Scenario: User performs summing operation
    Given User is on calculator home screen
    When User clicks on seven
    And User clicks on plus
    And User clicks on four
    And User clicks on equals
    Then User should see result
    
    