package hw4.steps;

import java.util.List;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class AssertionStep extends AbstractStep{

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Check username")
    public void checkUsername(String expectedUsername) {
        assertEquals(homePage.getUsername(), expectedUsername);
    }

    @Step("Check home page title")
    public void checkHomePageTitle(String expectedTitle) {
        assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Step("Check different element page title")
    public void checkDifferentElementsPageTitle(String expectedTitle) {
        assertEquals(differentElementsPage.getTitle(), expectedTitle);
    }

    @Step("Check header menu items")
    public void checkHeaderMenuItems(List<String> expectedHeaderMenuItems) {
        assertEquals(homePage.getHeaderMenuItemsText(), expectedHeaderMenuItems);
    }

    @Step("Check that there are {0} benefits")
    public void checkBenefitsCount(int expectedBenefitsCount) {
        assertEquals(homePage.getBenefitsImages().size(), expectedBenefitsCount);
    }

    @Step("Check benefits text")
    public void checkBenefitsText(List<String> expectedBenefitsText) {
        assertEquals(homePage.getBenefitsText(), expectedBenefitsText);
    }

    @Step("Check that frame with button exist on home page")
    public void checkFrameWithButtonIsExist() {
        assertNotNull(homePage.getFrameWithButton());
    }

    @Step("Check that frame with button has button, lol")
    public void checkThatFrameHasButton() {
        assertNotNull(homePage.getFrameButton());
    }

    @Step("Check sidebar menu items")
    public void checkSidebarMenuItems(List<String> expectedSidebarMenuItems) {
        assertEquals(homePage.getSidebarMenuItemsText(), expectedSidebarMenuItems);
    }

    @Step("Check logs panel items")
    public void checkLogs(List<String> partsOfLogs) {
        List<String> logs = differentElementsPage.getLogs();
        for (int i = 0; i < logs.size(); i++) {
            assertTrue(logs.get(i).contains(partsOfLogs.get(i)));
        }
    }

}
