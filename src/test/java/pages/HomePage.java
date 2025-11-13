package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    @FindBy(linkText = "A/B Testing")
    private WebElement abTestingLink;

    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemoveLink;

    @FindBy(linkText = "Checkboxes")
    private WebElement checkboxesLink;

    @FindBy(linkText = "Dropdown")
    private WebElement dropdownLink;

    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthLink;

    @FindBy(linkText = "Drag and Drop")
    private WebElement dragAndDropLink;

    @FindBy(linkText = "Horizontal Slider")
    private WebElement sliderLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    public void goToAbTesting() { abTestingLink.click(); }
    public void goToAddRemoveElements() { addRemoveLink.click(); }
    public void goToCheckboxes() { checkboxesLink.click(); }
    public void goToDropdown() { dropdownLink.click(); }
    public void goToFormAuth() { formAuthLink.click(); }
    public void goToDragAndDrop() { dragAndDropLink.click(); }
    public void goToSlider() { sliderLink.click(); }
}
