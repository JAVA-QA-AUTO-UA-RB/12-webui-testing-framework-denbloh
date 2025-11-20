package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;
    private final By checkboxes = By.cssSelector("form#checkboxes input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) { this.driver = driver; }

    public void selectAll() {
        List<WebElement> boxes = driver.findElements(checkboxes);
        for (WebElement box : boxes) if (!box.isSelected()) box.click();
    }

    public boolean allSelected() {
        List<WebElement> boxes = driver.findElements(checkboxes);
        return boxes.stream().allMatch(WebElement::isSelected);
    }
}
