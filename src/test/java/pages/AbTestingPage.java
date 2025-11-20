package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbTestingPage {
    private final WebDriver driver;
    private final By header = By.cssSelector("div.example h3");

    public AbTestingPage(WebDriver driver) { this.driver = driver; }

    public String getHeaderText() { return driver.findElement(header).getText(); }
}
