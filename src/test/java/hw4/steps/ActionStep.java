package hw4.steps;

import hw4.users.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep{

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Login with {loginUser} user")
    public void performLogin(User user) {
        homePage.performLogin(user);
    }

    @Step("Open home page")
    public void openHomePage() {
        homePage.openPage();
    }

    @Step("Open {0} page through header Service menu")
    public void openPageThroughHeaderServiceMenu(String page) {
        homePage.navToPageThroughHeaderServiceMenu(page);
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
