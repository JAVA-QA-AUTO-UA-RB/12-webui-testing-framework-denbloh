@ui @slider
Feature: Slider
  As a user
  I want to move the horizontal slider
  So that I can verify that the slider value changes accordingly

  Scenario: Move horizontal slider to 3.5
    Given I open the home page
    When I navigate to "Horizontal Slider" page
    And I move slider to value "3.5"
    Then slider value should be "3.5"
