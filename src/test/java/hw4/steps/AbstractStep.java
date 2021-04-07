package hw4.steps;

import hw4.pages.DifferentElementsPage;
import hw4.pages.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    HomePage homePage;
    DifferentElementsPage differentElementsPage;

    public AbstractStep(WebDriver driver) {
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }
}
