package hw3.pages;

import hw3.pages.components.Sidebar;
import hw3.pages.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

    public BasePage performLogin(String login, String password) {
        header.performLogin(login, password);
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
