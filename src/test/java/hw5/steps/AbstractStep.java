package hw5.steps;

import hw5.driver.WebDriverSingleton;
import hw5.pages.DifferentElementsPage;
import hw5.pages.HomePage;
import hw5.pages.UserTablePage;
import hw5.pages.components.Header;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected Header header;
    protected WebDriver driver;

    public AbstractStep() {
        driver = WebDriverSingleton.getDriverInstance();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
        header = homePage.getHeader();
    }
}
