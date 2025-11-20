package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private final WebDriver driver;
    private final By flash = By.id("flash");
    private final By logout = By.cssSelector(".icon-signout");

    public SecureAreaPage(WebDriver driver) { this.driver = driver; }

    public String getFlashText() { return driver.findElement(flash).getText(); }
    public void logout() { driver.findElement(logout).click(); }
}
