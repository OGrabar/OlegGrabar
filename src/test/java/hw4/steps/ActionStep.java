package hw4.steps;

import hw4.users.LoginUser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep{

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Login with {loginUser} user")
    public void performLogin(LoginUser loginUser) {
        homePage.performLogin(loginUser);
    }

    @Step("Open home page")
    public void openHomePage() {
        homePage.openPage();
    }

    @Step("Open different elements page")
    public void openDifferentElementsPage() {
        homePage.navToDifferentElementsPage();
    }

    @Step("Switch to frame with button")
    public void switchToFrameWithButton() {
        homePage.switchToFrameWithButton();
    }

    @Step("Switch back to index page")
    public void switchBackToIndexPage() {
        homePage.switchToIndexPage();
    }

    @Step("Click checkbox {0}")
    public void clickCheckBox(String checkBoxText) {
        differentElementsPage.clickCheckBox(checkBoxText);
    }

    @Step("Click radio button {0}")
    public void clickRadioButton(String radioButtonText) {
        differentElementsPage.clickRadioButton(radioButtonText);
    }

    @Step("Select dropdown option {0}")
    public void selectDropdownOption(String dropdownOptionText) {
        differentElementsPage.selectDropdownOption(dropdownOptionText);
    }
}
