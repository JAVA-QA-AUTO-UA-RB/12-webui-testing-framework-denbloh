package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.HomePage;

public class DropdownTest extends BaseTest {

    @Test
    public void selectOptionTwo() {
        new HomePage(driver).open(BASE_URL).goToDropdown();

        DropdownPage page = new DropdownPage(driver);
        page.selectOption2();
        String selected = page.getSelectedText();
        System.out.println("Test 4. Dropdown - Selected option: " + selected);

        Assert.assertEquals(selected, "Option 2");
    }
}
