package hw3.pages;

import hw3.users.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import hw3.pages.components.Header;
import hw3.pages.components.Sidebar;

import java.util.List;

public abstract class BasePage {

    protected Header header;
    protected Sidebar sidebar;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
        sidebar = new Sidebar(driver);
    }

    public BasePage performLogin(User user) {
        header.performLogin(user);
        return this;
    }

    public String getUsername() {
        return header.getUsername();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<String> getHeaderMenuItemsText() {
        return header.getMenuItemsText();
    }

    public List<String> getSidebarMenuItemsText() {
        return sidebar.getMenuItemsText();
    }

    public abstract BasePage openPage();
}
