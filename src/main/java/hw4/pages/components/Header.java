package hw4.pages.components;

import hw4.users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw4.utils.Utils.getNotEmptyTextFromWebElements;


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

    private static final String SERVICE_MENU_ITEM =
            "//ul[@class ='dropdown-menu']/descendant-or-self::*[text()[contains(., '%s')]]";

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header performLogin(User loginUser) {
        loginDropdown.click();
        loginField.sendKeys(loginUser.getLogin());
        passwordField.sendKeys(loginUser.getPassword());
        submitButton.click();
        return this;
    }

    public String getUsername() {
        return usernameElement.isDisplayed() ? usernameElement.getText() : null;
    }

    public List<String> getMenuItemsText() {
        return getNotEmptyTextFromWebElements(menuItems);
    }

    public void navToPageThroughHeaderServiceMenu(String page) {
        serviceMenu.click();
        driver.findElement(By.xpath(String.format(SERVICE_MENU_ITEM, page))).click();
    }
}
