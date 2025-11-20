@ui @auth
Feature: Form Authentication
  As a registered user
  I want to login and logout
  So that I can verify that login and logout functionality works correctly

  Scenario: Login and logout with valid credentials
    Given I open the home page
    When I navigate to "Form Authentication" page
    And I login with username "tomsmith" and password "SuperSecretPassword!"
    Then I should see a login message that contains "You logged into a secure area!"
    When I logout
    Then I should see a logout message that contains "You logged out"
