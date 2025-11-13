package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;
import pages.HomePage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void selectAllCheckboxes() {
        new HomePage(driver).open(BASE_URL).goToCheckboxes();

        CheckboxesPage page = new CheckboxesPage(driver);
        page.selectAll();
        boolean allSelected = page.areAllSelected();
        System.out.println("Test 3. Checkboxes - Are all checkboxes selected: " + allSelected);

        Assert.assertTrue(allSelected);
    }
}
