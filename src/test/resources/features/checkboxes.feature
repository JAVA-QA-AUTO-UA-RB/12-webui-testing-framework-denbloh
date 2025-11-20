@ui @checkboxes
Feature: Checkboxes
  As a user
  I want to select all checkboxes
  So that I can verify that all checkboxes are properly selected

  Scenario: Select all checkboxes
    Given I open the home page
    When I navigate to "Checkboxes" page
    And I select all checkboxes
    Then all checkboxes should be selected
