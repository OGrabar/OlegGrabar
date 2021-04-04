package hw3.tests;

import java.util.List;

import hw3.users.LoginUser;
import org.testng.annotations.Test;
import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;

public class SecondExerciseTest extends TestBase{

    private static final String EXPECTED_DIFFERENT_ELEMENTS_PAGE_TITLE = "Different Elements";
    private static final String WIND_CHECKBOX = "Wind";
    private static final String WATER_CHECKBOX = "Water";
    private static final String SELEN_RADIO_BUTTON = "Selen";
    private static final String YELLOW_DROPDOWN_OPTION = "Yellow";

    @Test
    public void secondExerciseTest() {
        //1. Open test site by URL
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        //2.Assert Browser title
        softAssert.assertEquals(homePage.getTitle(), EXPECTED_HOME_PAGE_TITLE);

        //3-4. Perform login. Assert Username is logined
        homePage.performLogin(LoginUser.ROMAN);
        softAssert.assertEquals(homePage.getUsername(), LoginUser.ROMAN.getUsername());

        //5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = homePage.navToDifferentElementsPage();
        softAssert.assertEquals(differentElementsPage.getTitle(), EXPECTED_DIFFERENT_ELEMENTS_PAGE_TITLE);

        //6. Select checkboxes
        differentElementsPage.clickCheckBox(WATER_CHECKBOX);
        differentElementsPage.clickCheckBox(WIND_CHECKBOX);

        //7. Select radio
        differentElementsPage.clickRadioButton(SELEN_RADIO_BUTTON);

        //8. Select in dropdown
        differentElementsPage.selectDropdownOption(YELLOW_DROPDOWN_OPTION);

        //9. Assert logs
        checkLogs(differentElementsPage.getLogs());

        softAssert.assertAll();
    }

    private static void checkLogs(List<String> logs) {
        softAssert.assertTrue(logs.get(3).contains(WATER_CHECKBOX));
        softAssert.assertTrue(logs.get(2).contains(WIND_CHECKBOX));
        softAssert.assertTrue(logs.get(1).contains(SELEN_RADIO_BUTTON));
        softAssert.assertTrue(logs.get(0).contains(YELLOW_DROPDOWN_OPTION));
    }
}