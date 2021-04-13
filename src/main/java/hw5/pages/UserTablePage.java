package hw5.pages;

import java.util.List;

import hw5.pages.components.LogsPanel;
import hw5.pages.components.UserTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserTablePage extends BasePage {

    private static final String USER_TABLE_PAGE_URL = "https://jdi-testing.github.io/jdi-light/user-table.html";
    protected UserTable userTable;

    private final LogsPanel logsPanel;

    public UserTablePage(WebDriver driver) {
        super(driver);
        userTable = new UserTable(driver);
        logsPanel = new LogsPanel(driver);
    }

    @Override
    public void openPage() {
        driver.get(USER_TABLE_PAGE_URL);
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return userTable.getNumberTypeDropdowns();
    }

    public List<WebElement> getUsernames() {
        return userTable.getUsernames();
    }

    public List<WebElement> getDescriptions() {
        return userTable.getDescriptions();
    }

    public List<WebElement> getCheckboxes() {
        return userTable.getCheckboxes();
    }

    public List<WebElement> getNumbers() {
        return userTable.getNumbers();
    }

    public WebElement getDropdownByUsername(String username) {
        return userTable.getDropdownByUsername(username);
    }

    public WebElement getCheckBoxByUsername(String username, String checkBoxText) {
        return userTable.getCheckBoxByUsername(username, checkBoxText);
    }

    public List<String> getLogs() {
        return logsPanel.getLogs();
    }
}
