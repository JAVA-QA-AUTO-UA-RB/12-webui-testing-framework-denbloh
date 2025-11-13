package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;
import pages.HomePage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addAndRemoveElements() {
        HomePage home = new HomePage(driver).open(BASE_URL);
        home.goToAddRemoveElements();

        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.clickAddButton(3);
        int addedCount = page.getDeleteButtonsCount();
        System.out.println("Test 2. Add/Remove Elements - Added elements count: " + addedCount);
        Assert.assertEquals(addedCount, 3);

        page.removeAllElements();
        int afterRemoval = page.getDeleteButtonsCount();
        System.out.println("Test 2. Add/Remove Elements - Remaining elements after removal: " + afterRemoval);
        Assert.assertEquals(afterRemoval, 0);
    }
}
