package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage {
    private final WebDriver driver;

    @FindBy(css = "#flash")
    private WebElement message;

    @FindBy(css = ".icon-signout")
    private WebElement logoutButton;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMessageText() {
        return message.getText();
    }

    public void logout() {
        logoutButton.click();
    }
}
