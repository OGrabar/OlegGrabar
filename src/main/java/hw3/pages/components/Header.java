package hw3.pages.components;

import hw3.pages.DifferentElementsPage;
import hw3.users.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw3.utils.Utils.getNotEmptyTextFromWebElements;


public class Header extends BaseComponent{

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

    @FindBy(xpath = "//a[@class = 'dropdown-toggle' and text()[contains(., 'Service')]]")
    private WebElement serviceMenu;

    @FindBy(xpath = "//ul[@class ='dropdown-menu']/descendant-or-self::*[text() = 'Different elements']")
    private WebElement differentElementsServiceMenuItem;

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header performLogin(User user) {
        loginDropdown.click();
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
        return this;
    }

    public String getUsername() {
        return usernameElement.isDisplayed() ? usernameElement.getText() : null;
    }

    public List<String> getMenuItemsText() {
        return getNotEmptyTextFromWebElements(menuItems);
    }

    public DifferentElementsPage navToDifferentElementsPage() {
        serviceMenu.click();
        differentElementsServiceMenuItem.click();
        return new DifferentElementsPage(driver);
    }
}
