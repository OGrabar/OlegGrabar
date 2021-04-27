package hw4.tests;

import hw4.users.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstExerciseTest extends TestBase {

    private static final int EXPECTED_BENEFITS_COUNT = 4;
    private static final List<String> EXPECTED_BENEFIT_TEXTS = new ArrayList<String>() {{
        add("To include good practices\nand ideas from successful\nEPAM project");
        add("To be flexible and\ncustomizable");
        add("To be multiplatform");
        add("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    }};
    private static final List<String> EXPECTED_HEADER_ITEMS_TEXT = new ArrayList<String>() {{
        add("HOME");
        add("CONTACT FORM");
        add("SERVICE");
        add("METALS & COLORS");
    }};
    private static final List<String> EXPECTED_SIDE_NAV_BAR_ITEMS_TEXT = new ArrayList<String>() {{
        add("Home");
        add("Contact form");
        add("Service");
        add("Metals & Colors");
        add("Elements packs");
    }};

    @Test(description = "First exercise test")
    public void firstExerciseTest() {
        //1. Open test site by URL
        actionStep.openHomePage();

        //2.Assert Browser title
        assertionStep.checkHomePageTitle(EXPECTED_HOME_PAGE_TITLE);

        //3-4. Perform login. Assert Username is logined
        actionStep.performLogin(user);
        assertionStep.checkUsername(user.getUsername());

        //5.Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.checkHeaderMenuItems(EXPECTED_HEADER_ITEMS_TEXT);

        //6.Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.checkBenefitsCount(EXPECTED_BENEFITS_COUNT);

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper tex
        assertionStep.checkBenefitsText(EXPECTED_BENEFIT_TEXTS);

        //8.Assert that there is the iframe with “Frame Button” exist
        assertionStep.checkFrameWithButtonIsExist();

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToFrameWithButton();
        assertionStep.checkThatFrameHasButton();

        //10.Switch to original window back
        actionStep.switchBackToIndexPage();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.checkSidebarMenuItems(EXPECTED_SIDE_NAV_BAR_ITEMS_TEXT);
    }
}
