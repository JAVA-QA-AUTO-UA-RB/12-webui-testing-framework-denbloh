---------------------------
Project contains a set of automated tests for the website (https://the-internet.herokuapp.com/), implemented using Selenium WebDriver, TestNG and Maven.

---------------------------
How to Run the Tests:
1. Make sure you have installed:
   - [Java JDK 17+](https://adoptium.net/)
   - [Apache Maven 3+](https://maven.apache.org/)
   - Google Chrome (latest stable version)
2. Clone or open the project in your IDE (e.g., IntelliJ IDEA).
3. Run tests from the terminal:
   mvn test
(OR click "Run" button in SeleniumTestngTest java class.)

Maven will:
- Automatically download dependencies (selenium-java, testng, webdrivermanager)
- Launch Google Chrome in incognito mode
- Execute all TestNG test methods in the file SeleniumTestngTest.java

---------------------------
Test Scenarios:
1 A/B Testing - Open the page and verify the text "A/B Test Control".
2 Add/Remove Elements - Add 3 "Delete" buttons, verify they appear, then remove them and check that they disappear.
3 Checkboxes - Select all checkboxes and verify all are selected.
4 Dropdown - Select “Option 2” and verify it’s selected.
5 Form Authentication - Log in with valid credentials, verify login success, log out, and confirm session end.
6 Drag and Drop - Drag element A onto element B and verify they’ve swapped places.
7 Horizontal Slider - Move the slider to a non-zero value and verify the displayed number changes.
---------------------------
Example Console Output after running:
Test 1. abTest - Header text is: A/B Test Variation 1
Test 2. Add and Remove - Delete buttons count after adding: 3
Test 2. Add and Remove - Delete buttons count after removing: 0
Test 3. Checkboxes - All checkboxes selected: true
Test 4. Dropdown - Selected option: Option 2
Test 5. Form Auth - Message after login: You logged into a secure area!
Test 5. formAuth - Message after logout: You logged out of the secure area!
Test 6. DragAndDrop - Column A now contains: B
Test 7. Slider - Current value: 4.5
===============================================
Default Suite
Total tests run: 7, Passes: 7, Failures: 0, Skips: 0
===============================================
BUILD SUCCESS

---------------------------
Notes:
- Browser opens once for all tests (described in @BeforeClass in BasicSetupTest.java).
- Each test opens its own page independently.
- Locators are written using both CSS and XPath (for comparison and flexibility, but XPath disabled at the moment).
---------------------------