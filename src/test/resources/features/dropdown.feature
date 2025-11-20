@ui @dropdown
Feature: Dropdown selection
  As a user
  I want to select an option from the dropdown
  So that I can verify the correct option is selected

  Scenario: Select Option 2
    Given I open the home page
    When I navigate to "Dropdown" page
    And I select option "Option 2"
    Then selected option should be "Option 2"
