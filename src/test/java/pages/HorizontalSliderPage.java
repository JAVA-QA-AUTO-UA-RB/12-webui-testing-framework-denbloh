package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage {
    private final WebDriver driver;

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement value;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void moveSliderRight(int steps) {
        for (int i = 0; i < steps; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getValue() {
        return value.getText();
    }
}
