@ui @auth
Feature: Form Authentication - Negative Scenarios
  As a visitor
  I want to attempt login with invalid credentials
  So that I can verify that proper error messages are shown

  Scenario: Login with invalid username
    Given I open the home page
    When I navigate to "Form Authentication" page
    And I login with username "wronguser" and password "SuperSecretPassword!"
    Then I should see a login message that contains "Your username is invalid!"

  Scenario: Login with empty username
    Given I open the home page
    When I navigate to "Form Authentication" page
    And I login with username "" and password "SuperSecretPassword!"
    Then I should see a login message that contains "Your username is invalid!"

  Scenario: Login with invalid password
    Given I open the home page
    When I navigate to "Form Authentication" page
    And I login with username "tomsmith" and password "wrongpass"
    Then I should see a login message that contains "Your password is invalid!"

  Scenario: Login with empty password
    Given I open the home page
    When I navigate to "Form Authentication" page
    And I login with username "tomsmith" and password ""
    Then I should see a login message that contains "Your password is invalid!"