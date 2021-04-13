package hw5.pages.components;

import hw5.users.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw5.utils.Utils.getNotEmptyTextFromWebElements;


public class Header extends BaseComponent {

    private static final String SERVICE_MENU_ITEM = "//ul[@class ='dropdown-menu']/descendant-or-self::*[contains(text(), '%s')]";

    @FindBy(className = "uui-profile-menu")
    private WebElement loginDropdown;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    protected WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement submitButton;

    @FindBy(id = "user-name")
    private WebElement usernameElement;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8>li>a")
    private List<WebElement> menuItems;

    public Header(WebDriver driver) {
        super(driver);
    }

    public void performLogin(LoginUser loginUser) {
        loginDropdown.click();
        loginField.sendKeys(loginUser.getLogin());
        passwordField.sendKeys(loginUser.getPassword());
        submitButton.click();
    }

    public String getUsername() {
        return usernameElement.isDisplayed() ? usernameElement.getText() : null;
    }

    public List<String> getMenuItemsText() {
        return getNotEmptyTextFromWebElements(menuItems);
    }

    public void clickHeaderMenuItem(String headerMenuItem) {
        menuItems.stream()
                .filter(item -> item.getText().toLowerCase().contains(headerMenuItem.toLowerCase()))
                .findFirst()
                .get()
                .click();
    }

    public void clickServiceMenuItem(String serviceMenuItem) {
        driver.findElement(By.xpath(String.format(SERVICE_MENU_ITEM, serviceMenuItem)))
                .click();
    }
}
