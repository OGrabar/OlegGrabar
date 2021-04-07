package hw4.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import hw4.pages.components.LogsPanel;

public class DifferentElementsPage extends BasePage {

    private static final String DEFAULT_DIFFERENT_ELEMENTS_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String DIFFERENT_ELEMENTS_URL = System.getProperty("url.dif_el", DEFAULT_DIFFERENT_ELEMENTS_URL);

    private final LogsPanel logsPanel;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        logsPanel = new LogsPanel(driver);
    }

    @Override
    public DifferentElementsPage openPage() {
        driver.get(DIFFERENT_ELEMENTS_URL);
        return this;
    }

    public void clickCheckBox(String checkBoxText) {
        driver.findElement(By.xpath(String.format("//label[@class = 'label-checkbox' and text()[contains(., '%s')]]", checkBoxText)))
                .click();
    }

    public void clickRadioButton(String radioButtonText) {
        driver.findElement(By.xpath(String.format("//label[@class = 'label-radio' and text()[contains(., '%s')]]", radioButtonText)))
                .click();
    }

    public void selectDropdownOption(String dropdownOption) {
        driver.findElement(By.xpath(String.format("//select/option[text()[contains(., '%s')]]", dropdownOption)))
                .click();
    }

    public List<String> getLogs() {
        return logsPanel.getLogs();
    }
}
