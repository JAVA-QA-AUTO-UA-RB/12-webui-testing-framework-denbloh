package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElementsPage {
    private final WebDriver driver;

    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addButton;

    @FindBy(css = "button.added-manually")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton(int times) {
        for (int i = 0; i < times; i++) addButton.click();
    }

    public int getDeleteButtonsCount() {
        return deleteButtons.size();
    }

    public void removeAllElements() {
        for (WebElement btn : deleteButtons) btn.click();
    }
}
