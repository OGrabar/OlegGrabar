package hw5.steps;

import hw5.users.LoginUser;
import io.cucumber.java.en.When;

public class WhenSteps extends AbstractStep {

    @When("I click {string} checkbox on Different elements page")
    public void clickCheckBox(String checkBoxText) {
        differentElementsPage.clickCheckBox(checkBoxText);
    }

    @When("I click {string} radio button on Different elements page")
    public void clickRadioButton(String radioButtonText) {
        differentElementsPage.clickRadioButton(radioButtonText);
    }

    @When("I select {string} dropdown option on Different elements page")
    public void selectYellowDropdownOptionOnDifferentElementsPage(String dropdownOption) {
        differentElementsPage.selectDropdownOption(dropdownOption);
    }

    @When("I login as user {string}")
    public void loginAsUser(String user) {
        header.performLogin(LoginUser.valueOf(user));
    }

    @When("I click on {string} button in Header")
    public void clickOnServiceButtonInHeader(String headerMenuItem) {
        header.clickHeaderMenuItem(headerMenuItem);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnDifferentElementsButtonInServiceDropdown(String serviceMenuItem) {
        header.clickServiceMenuItem(serviceMenuItem);
    }

    @When("I select {string} checkbox for {string} on User Table page")
    public void selectCheckboxForUserOnUserTablePage(String checkBoxText, String username) {
        userTablePage.getCheckBoxByUsername(username, checkBoxText)
                .click();
    }
}
