package hw4.tests;

import hw4.users.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SecondExerciseTest extends TestBase{

    private static final String EXPECTED_DIFFERENT_ELEMENTS_PAGE_TITLE = "Different Elements";
    private static final String DIFFERENT_ELEMENTS_PAGE = "Different elements";
    private static final String WIND_CHECKBOX = "Wind";
    private static final String WATER_CHECKBOX = "Water";
    private static final String SELEN_RADIO_BUTTON = "Selen";
    private static final String YELLOW_DROPDOWN_OPTION = "Yellow";

    private static final List<String> PARTS_OF_LOGS = new ArrayList<String>() {{
        add(YELLOW_DROPDOWN_OPTION);
        add(SELEN_RADIO_BUTTON);
        add(WIND_CHECKBOX);
        add(WATER_CHECKBOX);
    }};

    @Test(description = "Second exercise test")
    public void secondExerciseTest() {
        //1. Open test site by URL
        actionStep.openHomePage();

        //2.Assert Browser title
        assertionStep.checkHomePageTitle(EXPECTED_HOME_PAGE_TITLE);

        //3-4. Perform login. Assert Username is logined
        actionStep.performLogin(user);
        assertionStep.checkUsername(user.getUsername());

        //5. Open through the header menu Service -> Different Elements Page
        actionStep.openPageThroughHeaderServiceMenu(DIFFERENT_ELEMENTS_PAGE);
        assertionStep.checkDifferentElementsPageTitle(EXPECTED_DIFFERENT_ELEMENTS_PAGE_TITLE);

        //6. Select checkboxes
        actionStep.clickCheckBox(WATER_CHECKBOX);
        actionStep.clickCheckBox(WIND_CHECKBOX);

        //7. Select radio
        actionStep.clickRadioButton(SELEN_RADIO_BUTTON);

        //8. Select in dropdown
        actionStep.selectDropdownOption(YELLOW_DROPDOWN_OPTION);

        //9. Assert logs
        assertionStep.checkLogs(PARTS_OF_LOGS);
    }

}
