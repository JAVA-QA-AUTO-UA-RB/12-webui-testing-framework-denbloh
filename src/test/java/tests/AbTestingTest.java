package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbTestingPage;
import pages.HomePage;

public class AbTestingTest extends BaseTest {

    @Test
    public void verifyAbTestHeaderText() {
        HomePage home = new HomePage(driver).open(BASE_URL);
        home.goToAbTesting();

        AbTestingPage page = new AbTestingPage(driver);
        String headerText = page.getHeaderText();
        System.out.println("Test 1. A/B Test - Header text: " + headerText);

        Assert.assertTrue(headerText.contains("A/B Test"));
    }
}
