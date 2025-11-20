------------------------------------------------------------------
UI Test Automation with Cucumber (BDD) + TestNG

This project contains a set of automated UI tests for
https://the-internet.herokuapp.com, implemented using Cucumber (BDD) + TestNG
------------------------------------------------------------------
How to Run the Tests:

1) Make sure you have installed:
    - Java JDK 17+
    - Apache Maven 3+
    - Google Chrome (latest stable version)
2) Clone or open the project in your IDE (e.g., IntelliJ IDEA).
3) Run tests:
    - from the terminal for all tests: "mvn clean test"
    - from the terminal for tests with a specific Cucumber tag: mvn clean test -Dcucumber.filter.tags="@ui"
    - click "Run" button in CucumberTestRunner java class.

WebDriver starts automatically via: hooks/WebHooks.java
------------------------------------------------------------------
Test Scenarios Covered:
1) A/B Testing
- Open the page
- Verify text “A/B Test Control” is displayed
2) Add/Remove Elements
- Add 3 “Delete” buttons
- Verify all appeared
- Remove them
- Verify they disappeared
3) Checkboxes
- Select all checkboxes
- Verify all are checked
4) Dropdown
- Select Option 2
- Verify it is selected
5) Form Authentication
- Login with valid credentials
- Verify success message
- Logout
- Confirm session ended
6) Drag and Drop
- Drag A → B
- Confirm elements swapped
7) Horizontal Slider
- Move slider to non-zero value
- Confirm displayed number updates
8) Negative Authentication Cases
- Incorrect username
- Incorrect password
- Empty fields
- Verify correct error messages
------------------------------------------------------------------
Example Console Output:

Scenario: Dropdown
✓ Selected option: Option 2

Scenario: Add/Remove Elements
✓ Added 3 Delete buttons
✓ All buttons removed

Scenario: Form Authentication
✓ Logged in successfully
✓ Logged out successfully

8 scenarios (8 passed)
40 steps (40 passed)
BUILD SUCCESS
------------------------------------------------------------------
Notes:
- Driver launches once per scenario via Cucumber hooks (@Before, @After)
- WebDriver closes automatically after each test
- Tests use clear separation of:
    - Feature files (.feature)
    - Steps (actions and assertions)
    - Page Objects (UI logic)
------------------------------------------------------------------