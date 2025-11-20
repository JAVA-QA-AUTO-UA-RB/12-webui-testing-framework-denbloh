package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    private final WebDriver driver;
    private final By slider = By.cssSelector("input[type='range']");
    private final By value = By.id("range");

    public HorizontalSliderPage(WebDriver driver) { this.driver = driver; }

    public void moveRightSteps(int steps) {
        WebElement s = driver.findElement(slider);
        for (int i = 0; i < steps; i++) s.sendKeys(Keys.ARROW_RIGHT);
    }

    public String getValue() {
        return driver.findElement(value).getText();
    }
}
