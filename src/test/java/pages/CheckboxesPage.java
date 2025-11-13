package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;

    @FindBy(css = "form#checkboxes input[type='checkbox']")
    private List<WebElement> checkboxes;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectAll() {
        for (WebElement box : checkboxes)
            if (!box.isSelected()) box.click();
    }

    public boolean areAllSelected() {
        return checkboxes.stream().allMatch(WebElement::isSelected);
    }
}
