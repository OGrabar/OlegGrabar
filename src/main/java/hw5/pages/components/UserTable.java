package hw5.pages.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTable extends BaseComponent{

    private static final String USER_DROPDOWN = "//td/a[contains(text(), '%s')]/parent::td/parent::tr/td/select";
    private static final String USER_CHECKBOX = "//td/a[contains(text(), '%s')]/parent::td/parent::tr//label[contains(text(), '%s')]";

    @FindBy(css = "tbody select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "tbody tr td a")
    private List<WebElement> usernames;

    @FindBy(css = "tbody tr td div span")
    private List<WebElement> descriptions;

    @FindBy(css = "tbody tr td div input")
    private List<WebElement> checkboxes;

    @FindBy(css = "tbody tr > :nth-of-type(1)")
    private List<WebElement> numbers;

    public UserTable(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getNumbers() {
        return numbers;
    }

    public WebElement getDropdownByUsername(String username) {
        return driver.findElement(By.xpath(String.format(USER_DROPDOWN, username)));
    }

    public WebElement getCheckBoxByUsername(String username, String checkBoxText) {
        return driver.findElement(By.xpath(String.format(USER_CHECKBOX, username, checkBoxText)));
    }
}
