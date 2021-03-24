package hw2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SecondExerciseTest extends TestBase{

    private static final String EXPECTED_DIFFERENT_ELEMENTS_PAGE_TITLE = "Different Elements";
    private static final String WIND_CHECKBOX = "Wind";
    private static final String WATER_CHECKBOX = "Water";
    private static final String SELEN_RADIO_BUTTON = "Selen";
    private static final String YELLOW_DROPDOWN_OPTION = "Yellow";

    private static final String SERVICE_MENU_XPATH_SELECTOR =
            "//a[@class = 'dropdown-toggle' and text()[contains(., 'Service')]]";
    private static final String SERVICE_MENU_DIFFERENT_ELEMENTS_XPATH_SELECTOR =
            "//ul[@class ='dropdown-menu']/descendant-or-self::*[text() = 'Different elements']";
    private static final String LOGS_XPATH_SELECTOR = "//ul[@class = 'panel-body-list logs']/li";
    private static final String CHECKBOX_XPATH_SELECTOR = "//label[@class = 'label-checkbox' and text()[contains(., '%s')]]";
    private static final String RADIO_BUTTON_XPATH_SELECTOR = "//label[@class = 'label-radio' and text()[contains(., '%s')]]";
    private static final String DROPDOWN_OPTION_XPATH_SELECTOR = "//select/option[text()[contains(., '%s')]]";

    @Test
    public void secondExerciseTest() {
        //2.Assert Browser title
        checkBrowserTitle();
        //3-4. Perform login. Assert Username
        performLogin();

        //5. Open through the header menu Service -> Different Elements Page
        goToDifferentElementsPage();

        //6. Select checkboxes
        clickCheckBox(WATER_CHECKBOX);
        clickCheckBox(WIND_CHECKBOX);

        //7. Select radio
        clickRadioButton(SELEN_RADIO_BUTTON);

        //8. Select in dropdown
        selectDropdownOption(YELLOW_DROPDOWN_OPTION);

        //9. Assert logs
        checkLogs();

        softAssert.assertAll();
    }

    private static void goToDifferentElementsPage() {
        WebElement topNavigationBarServiceItem = driver.findElement(By.xpath(SERVICE_MENU_XPATH_SELECTOR));
        topNavigationBarServiceItem.click();
        WebElement serviceMenuDifferentElementItem = driver.findElement(By.xpath(SERVICE_MENU_DIFFERENT_ELEMENTS_XPATH_SELECTOR));
        serviceMenuDifferentElementItem.click();
        softAssert.assertEquals(driver.getTitle(), EXPECTED_DIFFERENT_ELEMENTS_PAGE_TITLE);
    }

    private static void clickCheckBox(String checkBox) {
        driver.findElement(By.xpath(String.format(CHECKBOX_XPATH_SELECTOR, checkBox))).click();
    }

    private static void clickRadioButton(String radioButtonText) {
        driver.findElement(By.xpath(String.format(RADIO_BUTTON_XPATH_SELECTOR, radioButtonText))).click();
    }

    private static void selectDropdownOption(String dropdownOption) {
       driver.findElement(By.xpath(String.format(DROPDOWN_OPTION_XPATH_SELECTOR, dropdownOption))).click();
    }

    private static void checkLogs() {
        List<WebElement> logsItems = driver.findElements(By.xpath(LOGS_XPATH_SELECTOR));
        List<String> logsText = getNotEmptyTextFromWebElements(logsItems);

        softAssert.assertTrue(logsText.get(logsText.size() - 1).contains(WATER_CHECKBOX));
        softAssert.assertTrue(logsText.get(logsText.size() - 2).contains(WIND_CHECKBOX));
        softAssert.assertTrue(logsText.get(logsText.size() - 3).contains(SELEN_RADIO_BUTTON));
        softAssert.assertTrue(logsText.get(logsText.size() - 4).contains(YELLOW_DROPDOWN_OPTION));
    }
}
