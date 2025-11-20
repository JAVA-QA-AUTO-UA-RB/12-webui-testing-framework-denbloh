@ui @addremove
Feature: Add / Remove elements
  As a user
  I want to add and remove elements
  So that I can verify that adding and deleting elements works correctly

  Scenario: Add three elements and remove them
    Given I open the home page
    When I navigate to "Add/Remove Elements" page
    And I add 3 elements
    Then I should see 3 delete buttons
    When I remove all elements
    Then I should see 0 delete buttons
