package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static hw5.utils.Utils.getNotEmptyTextFromWebElements;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ThenSteps extends AbstractStep {

    @Then("{string} page should be opened")
    public void checkPageTitle(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    @Then("Username should be {string}")
    public void checkUsername(String expectedTitle) {
        assertEquals(homePage.getUsername(), expectedTitle);
    }

    @Then("Logs should be on Logs panel on Different elements page")
    public void logsShouldBeOnLogsPanelOnDifferentElementsPage(DataTable partsOfLogsTable) {
        List<String> logs = differentElementsPage.getLogs();
        List<String> partsOfLogs = partsOfLogsTable.asList();
        for (int i = 0; i < logs.size(); i++) {
            assertTrue(logs.get(i).contains(partsOfLogs.get(i)));
        }
    }

    @Then("Logs should be on Logs panel on User Table page")
    public void logsShouldBeOnLogsPanelOnUserTablePage(DataTable partsOfLogsTable) {
        List<String> logs = userTablePage.getLogs();
        List<String> partsOfLogs = partsOfLogsTable.asList();
        for (int i = 0; i < logs.size(); i++) {
            assertTrue(logs.get(i).contains(partsOfLogs.get(i)));
        }
    }


    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int expectedCountOfNumberTypeDropdowns) {
        List<WebElement> numberTypeDropdowns = userTablePage.getNumberTypeDropdowns().stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
        assertEquals(numberTypeDropdowns.size(), expectedCountOfNumberTypeDropdowns);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int expectedCountOfUserName) {
        List<WebElement> usernames = userTablePage.getUsernames().stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
        assertEquals(usernames.size(), expectedCountOfUserName);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int expectedCountOfDescriptions) {
        List<WebElement> descriptions = userTablePage.getDescriptions().stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
        assertEquals(descriptions.size(), expectedCountOfDescriptions);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int expectedCountOnCheckboxes) {
        List<WebElement> checkboxes = userTablePage.getCheckboxes().stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
        assertEquals(checkboxes.size(), expectedCountOnCheckboxes);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable expectedUserTable) {
        List<List<String>> expectedUserTableContent = expectedUserTable.asLists()
                .subList(1, expectedUserTable.height());
        List<List<String>> userTableContent = getUserTableContent();
        assertEquals(userTableContent, expectedUserTableContent);
    }

    @Then("Dropdown should contain values in column Type for user {string}")
    public void dropdownShouldContainValuesInColumnTypeForUserRoman(String username, DataTable expectedDropdownOptionsTable) {
        Select userDropdown = new Select(userTablePage.getDropdownByUsername(username));
        List<String> userDropdownOptions = getNotEmptyTextFromWebElements(userDropdown.getOptions());
        List<String> expectedDropdownOptions = expectedDropdownOptionsTable.asList()
                .subList(1, expectedDropdownOptionsTable.height());
        assertEquals(userDropdownOptions, expectedDropdownOptions);
    }

    public List<List<String>> getUserTableContent() {
        List<String> numbers = getNotEmptyTextFromWebElements(userTablePage.getNumbers());
        List<String> users = getNotEmptyTextFromWebElements(userTablePage.getUsernames());
        List<String> descriptions = getNotEmptyTextFromWebElements(userTablePage.getDescriptions());

        List<List<String>> expectedUserTable = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            //Regret that Java 9 is forbidden
            List<String> userTableRow = new ArrayList<>();
            userTableRow.add(numbers.get(i).replaceAll("\n", " "));
            userTableRow.add(users.get(i).replaceAll("\n", " "));
            userTableRow.add(descriptions.get(i).replaceAll("\n", " "));
            expectedUserTable.add(userTableRow);
        }
        return expectedUserTable;
    }
}
