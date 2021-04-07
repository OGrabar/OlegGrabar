package hw4.tests;

import org.testng.annotations.Test;


public class FailedTest extends TestBase {

    @Test(description = "Failed test")
    public void failedTest() {
        //1. Open test site by URL
        actionStep.openHomePage();

        //2.Assert Browser title
        assertionStep.checkHomePageTitle(EXPECTED_HOME_PAGE_TITLE + " oops");
    }
}
