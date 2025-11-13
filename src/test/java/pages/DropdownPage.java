package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage {
    private final WebDriver driver;

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    @FindBy(css = "#dropdown option:checked")
    private WebElement selectedOption;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectOption2() {
        dropdown.click();
        dropdown.findElement(org.openqa.selenium.By.cssSelector("option[value='2']")).click();
    }

    public String getSelectedText() {
        return selectedOption.getText();
    }
}
