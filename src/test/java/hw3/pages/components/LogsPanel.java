package hw3.pages.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static hw3.Utils.Utils.getNotEmptyTextFromWebElements;

public class LogsPanel extends BaseComponent{

    @FindBy(xpath = "//ul[@class = 'panel-body-list logs']/li")
    List<WebElement> logsItems;

    public LogsPanel(WebDriver driver) {
        super(driver);
    }

    public List<String> getLogs() {
        return getNotEmptyTextFromWebElements(logsItems);
    }

}
