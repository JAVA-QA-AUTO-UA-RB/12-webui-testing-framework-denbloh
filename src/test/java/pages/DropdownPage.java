package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownPage {
    private final WebDriver driver;
    private final By select = By.id("dropdown");

    public DropdownPage(WebDriver driver) { this.driver = driver; }

    public void selectByValue(String value) {
        driver.findElement(select).click();
        driver.findElement(By.cssSelector("#dropdown option[value='2']")).click();
    }

    public String getSelectedText() {
        return driver.findElement(By.cssSelector("#dropdown option:checked")).getText();
    }
}
