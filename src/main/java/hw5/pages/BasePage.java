package hw5.pages;

import hw5.users.LoginUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import hw5.pages.components.Header;
import hw5.pages.components.Sidebar;

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

    public void performLogin(LoginUser loginUser) {
        header.performLogin(loginUser);
    }

    public void clickHeaderMenuItem(String headerMenuItem) {
        header.clickHeaderMenuItem(headerMenuItem);
    }

    public void clickServiceMenuItem(String serviceMenuItem) {
        header.clickServiceMenuItem(serviceMenuItem);
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

    public abstract void openPage();

    public Header getHeader() {
        return header;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }
}
