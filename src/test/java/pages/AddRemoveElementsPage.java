package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AddRemoveElementsPage {
    private final WebDriver driver;
    private final By addBtn = By.cssSelector("button[onclick='addElement()']");
    private final By deleteBtns = By.cssSelector("button.added-manually");

    public AddRemoveElementsPage(WebDriver driver) { this.driver = driver; }

    public void addElements(int n) {
        for (int i = 0; i < n; i++) driver.findElement(addBtn).click();
    }

    public int deleteButtonsCount() {
        List<?> els = driver.findElements(deleteBtns);
        return els.size();
    }

    public void removeAll() {
        List<?> els = driver.findElements(deleteBtns);
        while (driver.findElements(deleteBtns).size() > 0) {
            driver.findElements(deleteBtns).get(0).click();
        }
    }
}
