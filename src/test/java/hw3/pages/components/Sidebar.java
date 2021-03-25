package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw3.Utils.Utils.getNotEmptyTextFromWebElements;

public class Sidebar extends BaseComponent{

    @FindBy(css = ".sidebar-menu>li>a>span")
    protected List<WebElement> menuItems;

    public Sidebar(WebDriver driver) {
        super(driver);
    }

    public List<String> getMenuItemsText() {
        return getNotEmptyTextFromWebElements(menuItems);
    }

}
