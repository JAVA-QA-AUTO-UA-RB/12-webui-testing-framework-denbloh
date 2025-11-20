@ui @drag
Feature: Drag and Drop
  As a user
  I want to drag element A to element B
  So that I can verify that the elements swap positions correctly

  Scenario: Drag A to B
    Given I open the home page
    When I navigate to "Drag and Drop" page
    And I drag element A to B
    Then column A header should be "B"
