package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

public class AuthenticationTest extends BaseTest {

    @Test
    public void validLoginAndLogout() {
        new HomePage(driver).open(BASE_URL).goToFormAuth();

        LoginPage login = new LoginPage(driver);
        login.login("tomsmith", "SuperSecretPassword!");

        SecureAreaPage secure = new SecureAreaPage(driver);
        String message = secure.getMessageText();
        System.out.println("Test 5. Login - Success message: " + message);
        Assert.assertTrue(message.contains("You logged into a secure area!"));

        secure.logout();
        String logoutMessage = secure.getMessageText();
        System.out.println("Test 5. Login - Logout message: " + logoutMessage);
        Assert.assertTrue(logoutMessage.contains("You logged out"));
    }
}
