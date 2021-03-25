package hw3.pages;

import java.util.List;
import hw3.pages.components.LogsPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DifferentElementsPage extends BasePage {

    private static final String DEFAULT_DIFFERENT_ELEMENTS_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String DIFFERENT_ELEMENTS_URL = System.getProperty("url.dif_el", DEFAULT_DIFFERENT_ELEMENTS_URL);

    private static final String CHECKBOX_XPATH_SELECTOR = "//label[@class = 'label-checkbox' and text()[contains(., '%s')]]";
    private static final String RADIO_BUTTON_XPATH_SELECTOR = "//label[@class = 'label-radio' and text()[contains(., '%s')]]";
    private static final String DROPDOWN_OPTION_XPATH_SELECTOR = "//select/option[text()[contains(., '%s')]]";

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
        driver.findElement(By.xpath(String.format(CHECKBOX_XPATH_SELECTOR, checkBoxText))).click();
    }

    public void clickRadioButton(String radioButtonText) {
        driver.findElement(By.xpath(String.format(RADIO_BUTTON_XPATH_SELECTOR, radioButtonText))).click();
    }

    public void selectDropdownOption(String dropdownOption) {
        driver.findElement(By.xpath(String.format(DROPDOWN_OPTION_XPATH_SELECTOR, dropdownOption))).click();
    }

    public List<String> getLogs() {
        return logsPanel.getLogs();
    }
}
