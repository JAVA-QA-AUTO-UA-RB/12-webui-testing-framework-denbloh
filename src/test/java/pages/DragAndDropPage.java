package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    private final WebDriver driver;
    private final By columnA = By.id("column-a");
    private final By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver) { this.driver = driver; }

    public void dragAtoB() {
        WebElement a = driver.findElement(columnA);
        WebElement b = driver.findElement(columnB);
        new Actions(driver).dragAndDrop(a, b).perform();
    }

    public String getColumnAHeader() {
        return driver.findElement(columnA).findElement(By.tagName("header")).getText();
    }
}
