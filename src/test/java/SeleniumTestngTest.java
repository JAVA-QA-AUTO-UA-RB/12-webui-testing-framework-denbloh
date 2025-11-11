import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

// This test class inherits BasicSetupTest class, where the browser is initialized
// browser variable is available here as it's inherited, so you'll have it available at any place
public class SeleniumTestngTest extends BasicSetupTest {

    private final String BASE_URL = "https://the-internet.herokuapp.com/";

//    @Test
//    public void abTestingPageHasSpecificTextTest() {
//        browser.get("https://the-internet.herokuapp.com/");
//        // Write your code here (just an example provided)
//        WebElement abTestingTaskLink = browser.findElement(By.linkText("A/B Testing"));
//        abTestingTaskLink.click();
//
//        // Write your assertions in the after the steps of scenario are executed to validate results
//        Assert.assertTrue(true);
//    }


    @Test
    public void PageHasSpecificTextTest() {
        browser.get(BASE_URL);
        browser.findElement(By.linkText("A/B Testing")).click();

        WebElement header = browser.findElement(By.cssSelector("div.example h3"));
        // WebElement header = browser.findElement(By.xpath("//div[@class='example']/h3"));

        String headerText = header.getText();
        System.out.println("Test 1. abTest - Header text is: " + headerText);

        Assert.assertTrue(headerText.contains("A/B Test Control"));
//        Assert.assertTrue(headerText.contains("A/B Test Control") || headerText.contains("A/B Test Variation"));
    }


    @Test
    public void addRemoveElementsTest() {
        browser.get(BASE_URL);
        browser.findElement(By.linkText("Add/Remove Elements")).click();

        WebElement addButton = browser.findElement(By.cssSelector("button[onclick='addElement()']"));
        // WebElement addButton = browser.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0; i < 3; i++) {
            addButton.click();
        }

        int deleteButtons = browser.findElements(By.cssSelector("button.added-manually")).size();
        // int deleteButtons = browser.findElements(By.xpath("//button[contains(@class,'added-manually')]")).size();

        System.out.println("Test 2. Add and Remove - Delete buttons count after adding: " + deleteButtons);
        Assert.assertEquals(deleteButtons, 3);

        for (WebElement btn : browser.findElements(By.cssSelector("button.added-manually"))) {
            btn.click();
        }

        int remaining = browser.findElements(By.cssSelector("button.added-manually")).size();
        System.out.println("Test 2. Add and Remove - Delete buttons count after removing: " + remaining);
        Assert.assertEquals(remaining, 0);
    }


    @Test
    public void checkboxesTest() {
        browser.get(BASE_URL);
        browser.findElement(By.linkText("Checkboxes")).click();

        for (WebElement checkbox : browser.findElements(By.cssSelector("form#checkboxes input[type='checkbox']"))) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
//         for (WebElement checkbox : browser.findElements(By.xpath("//form[@id='checkboxes']//input[@type='checkbox']"))) {
//             if (!checkbox.isSelected()) {
//                        checkbox.click();
//                    }
//         }

        boolean allChecked = browser.findElements(By.cssSelector("form#checkboxes input[type='checkbox']"))
                .stream().allMatch(WebElement::isSelected);
        // boolean allChecked = browser.findElements(By.xpath("//form[@id='checkboxes']//input[@type='checkbox']"))
        //         .stream().allMatch(WebElement::isSelected);

        System.out.println("Test 3. Checkboxes - All checkboxes selected: " + allChecked);
        Assert.assertTrue(allChecked);
    }


    @Test
    public void dropdownTest() {
        browser.get(BASE_URL);
        browser.findElement(By.linkText("Dropdown")).click();

        WebElement dropdown = browser.findElement(By.cssSelector("#dropdown"));
        // WebElement dropdown = browser.findElement(By.xpath("//select[@id='dropdown']"));

        dropdown.click();
        dropdown.findElement(By.cssSelector("option[value='2']")).click();
        // dropdown.findElement(By.xpath("//option[@value='2']")).click();

        WebElement selectedOption = browser.findElement(By.cssSelector("#dropdown option:checked"));
        // WebElement selectedOption = browser.findElement(By.xpath("//select[@id='dropdown']/option[@selected='selected']"));

        String selectedText = selectedOption.getText();
        System.out.println("Test 4. Dropdown - Selected option: " + selectedText);

        Assert.assertEquals(selectedText, "Option 2");
    }


    @Test
    public void formAuthenticationTest() {
        browser.get(BASE_URL);
        browser.findElement(By.linkText("Form Authentication")).click();

        browser.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        browser.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.cssSelector("button[type='submit']")).click();
        // browser.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        // browser.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        // browser.findElement(By.xpath("//button[@type='submit']")).click();

        String successMsg = browser.findElement(By.cssSelector("#flash")).getText();
        // String successMsg = browser.findElement(By.xpath("//div[@id='flash']")).getText();

        System.out.println("Test 5. Form Auth - Message after login: " + successMsg);
        Assert.assertTrue(successMsg.contains("You logged into a secure area!"));

        browser.findElement(By.cssSelector(".icon-signout")).click();
        // browser.findElement(By.xpath("//a[@class='button secondary radius']")).click();

        String logoutMsg = browser.findElement(By.cssSelector("#flash")).getText();
        System.out.println("Test 5. formAuth - Message after logout: " + logoutMsg);
        Assert.assertTrue(logoutMsg.contains("You logged out of the secure area!"));
    }


    @Test
    public void dragAndDropTest() {
        browser.get(BASE_URL);
        browser.findElement(By.linkText("Drag and Drop")).click();

        WebElement columnA = browser.findElement(By.cssSelector("#column-a"));
        WebElement columnB = browser.findElement(By.cssSelector("#column-b"));
        // WebElement columnA = browser.findElement(By.xpath("//div[@id='column-a']"));
        // WebElement columnB = browser.findElement(By.xpath("//div[@id='column-b']"));

        Actions actions = new Actions(browser);
        actions.dragAndDrop(columnA, columnB).perform();

        String columnAText = columnA.findElement(By.tagName("header")).getText();
        // String columnAText = columnA.findElement(By.xpath(".//header")).getText();

        System.out.println("Test 6. DragAndDrop - Column A now contains: " + columnAText);
        Assert.assertTrue(columnAText.equals("B"));
    }


    @Test
    public void horizontalSliderTest() {
        browser.get(BASE_URL);
        browser.findElement(By.linkText("Horizontal Slider")).click();

        WebElement slider = browser.findElement(By.cssSelector("input[type='range']"));
        WebElement value = browser.findElement(By.id("range"));

        for (int i = 0; i < 7; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

        String currentValue = value.getText();
        System.out.println("7. Slider - Current value: " + currentValue);

        Assert.assertEquals(currentValue, "3.5");
    }

}
