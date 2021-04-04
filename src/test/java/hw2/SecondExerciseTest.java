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


    @Test
    public void secondExerciseTest() {
        //2.Assert Browser title
        checkBrowserTitle();
        //3-4. Perform login. Assert Username
        performLogin(LoginUser.ROMAN);

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

    private void goToDifferentElementsPage() {
        WebElement topNavigationBarServiceItem = driver
                .findElement(By.xpath("//a[@class = 'dropdown-toggle' and text()[contains(., 'Service')]]"));
        topNavigationBarServiceItem.click();
        WebElement serviceMenuDifferentElementItem = driver
                .findElement(By.xpath("//ul[@class ='dropdown-menu']/descendant-or-self::*[text() = 'Different elements']"));
        serviceMenuDifferentElementItem.click();
        softAssert.assertEquals(driver.getTitle(), EXPECTED_DIFFERENT_ELEMENTS_PAGE_TITLE);
    }

    private void clickCheckBox(String checkBox) {
        driver.findElement(By.xpath(String.format("//label[@class = 'label-checkbox' and text()[contains(., '%s')]]", checkBox)))
                .click();
    }

    private void clickRadioButton(String radioButtonText) {
        driver.findElement(By.xpath(String.format("//label[@class = 'label-radio' and text()[contains(., '%s')]]", radioButtonText)))
                .click();
    }

    private void selectDropdownOption(String dropdownOption) {
       driver.findElement(By.xpath(String.format("//select/option[text()[contains(., '%s')]]", dropdownOption))).click();
    }

    private void checkLogs() {
        List<WebElement> logsItems = driver.findElements(By.xpath("//ul[@class = 'panel-body-list logs']/li"));
        List<String> logsText = getNotEmptyTextFromWebElements(logsItems);

        softAssert.assertTrue(logsText.get(3).contains(WATER_CHECKBOX));
        softAssert.assertTrue(logsText.get(2).contains(WIND_CHECKBOX));
        softAssert.assertTrue(logsText.get(1).contains(SELEN_RADIO_BUTTON));
        softAssert.assertTrue(logsText.get(0).contains(YELLOW_DROPDOWN_OPTION));
    }
}
