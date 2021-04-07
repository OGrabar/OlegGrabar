package hw4.tests;

import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase {

    protected static final String EXPECTED_HOME_PAGE_TITLE = "Home Page";

    protected static WebDriver driver;

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
    public void beforeClass(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        context.setAttribute("driver", driver);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
