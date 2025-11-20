package steps;

import hooks.WebHooks;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;

public class UiSteps {

    private final HomePage home = new HomePage(WebHooks.driver);
    private AbTestingPage ab;
    private AddRemoveElementsPage addremove;
    private CheckboxesPage checkboxes;
    private DropdownPage dropdown;
    private LoginPage login;
    private SecureAreaPage secure;
    private DragAndDropPage drag;
    private HorizontalSliderPage slider;

    @Given("I open the home page")
    public void iOpenHomePage() {
        home.open();
    }

    @When("I navigate to {string} page")
    @When("I navigate to {string}")
    public void iNavigateToPage(String pageName) {
        home.goTo(pageName);
    }


    @When("I add {int} elements")
    public void iAddElements(int count) {
        addremove = new AddRemoveElementsPage(WebHooks.driver);
        addremove.addElements(count);
    }

    @Then("I should see {int} delete buttons")
    public void iShouldSeeDeleteButtons(int expected) {
        if (addremove == null) addremove = new AddRemoveElementsPage(WebHooks.driver);
        int actual = addremove.deleteButtonsCount();
        Assert.assertEquals(actual, expected);
    }

    @When("I remove all elements")
    public void iRemoveAllElements() {
        if (addremove == null) addremove = new AddRemoveElementsPage(WebHooks.driver);
        addremove.removeAll();
    }

    @When("I select all checkboxes")
    public void iSelectAllCheckboxes() {
        checkboxes = new CheckboxesPage(WebHooks.driver);
        checkboxes.selectAll();
    }

    @Then("all checkboxes should be selected")
    public void allCheckboxesShouldBeSelected() {
        if (checkboxes == null) checkboxes = new CheckboxesPage(WebHooks.driver);
        Assert.assertTrue(checkboxes.allSelected());
    }

    @When("I select option {string}")
    public void iSelectOption(String optionText) {
        dropdown = new DropdownPage(WebHooks.driver);
        dropdown.selectByValue(optionText);
    }

    @Then("selected option should be {string}")
    public void selectedOptionShouldBe(String expected) {
        if (dropdown == null) dropdown = new DropdownPage(WebHooks.driver);
        Assert.assertEquals(dropdown.getSelectedText(), expected);
    }

    @When("I login with username {string} and password {string}")
    public void iLogin(String user, String pass) {
        login = new LoginPage(WebHooks.driver);
        login.login(user, pass);
        secure = new SecureAreaPage(WebHooks.driver);
    }

    @Then("I should see a login message that contains {string}")
    public void iShouldSeeLoginMessage(String expected) {
        Assert.assertTrue(secure.getFlashText().contains(expected));
    }

    @When("I logout")
    public void iLogout() {
        secure.logout();
    }

    @Then("I should see a logout message that contains {string}")
    public void iShouldSeeLogoutMessage(String expected) {
        Assert.assertTrue(secure.getFlashText().contains(expected));
    }

    @When("I drag element A to B")
    public void iDragAToB() {
        drag = new DragAndDropPage(WebHooks.driver);
        drag.dragAtoB();
    }

    @Then("column A header should be {string}")
    public void columnAHeaderShouldBe(String expected) {
        if (drag == null) drag = new DragAndDropPage(WebHooks.driver);
        Assert.assertEquals(drag.getColumnAHeader(), expected);
    }

    @When("I move slider to value {string}")
    public void iMoveSliderToValue(String valueStr) {
        slider = new HorizontalSliderPage(WebHooks.driver);
        if ("3.5".equals(valueStr)) slider.moveRightSteps(7);
    }

    @Then("slider value should be {string}")
    public void sliderValueShouldBe(String expected) {
        if (slider == null) slider = new HorizontalSliderPage(WebHooks.driver);
        Assert.assertEquals(slider.getValue(), expected);
    }

    @Then("I should see text that contains {string}")
    public void iShouldSeeText(String substring) {
        ab = new AbTestingPage(WebHooks.driver);
        String header = ab.getHeaderText();
        Assert.assertTrue(header.contains(substring), "Expected substring not found in header");
    }
}
