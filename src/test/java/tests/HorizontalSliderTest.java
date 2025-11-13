package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void moveSliderToValue() {
        new HomePage(driver).open(BASE_URL).goToSlider();

        HorizontalSliderPage page = new HorizontalSliderPage(driver);
        page.moveSliderRight(7);

        String currentValue = page.getValue();
        System.out.println("Test 7. Slider - Current value: " + currentValue);

        Assert.assertEquals(currentValue, "3.5");
    }
}
