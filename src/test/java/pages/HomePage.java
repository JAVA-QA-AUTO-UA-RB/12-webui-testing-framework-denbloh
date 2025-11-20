package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By abTestingLink = By.linkText("A/B Testing");
    private final By addRemoveLink = By.linkText("Add/Remove Elements");
    private final By checkboxesLink = By.linkText("Checkboxes");
    private final By dropdownLink = By.linkText("Dropdown");
    private final By formAuthLink = By.linkText("Form Authentication");
    private final By dragAndDropLink = By.linkText("Drag and Drop");
    private final By sliderLink = By.linkText("Horizontal Slider");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void goTo(String pageLinkText) {
        driver.findElement(By.linkText(pageLinkText)).click();
    }

//    public void goToAbTesting() { driver.findElement(abTestingLink).click(); }
//    public void goToAddRemove() { driver.findElement(addRemoveLink).click(); }
//    public void goToCheckboxes() { driver.findElement(checkboxesLink).click(); }
//    public void goToDropdown() { driver.findElement(dropdownLink).click(); }
//    public void goToFormAuth() { driver.findElement(formAuthLink).click(); }
//    public void goToDragAndDrop() { driver.findElement(dragAndDropLink).click(); }
//    public void goToSlider() { driver.findElement(sliderLink).click(); }

}
