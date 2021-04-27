package hw4.tests;

import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import hw4.users.User;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class TestBase {

    protected static final String EXPECTED_HOME_PAGE_TITLE = "Home Page";

    protected static WebDriver driver;

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    private static final String DEFAULT_LOGIN = "Roman";
    private static final String DEFAULT_PASSWORD = "Jdi1234";
    private static final String DEFAULT_USERNAME = "ROMAN IOVLEV";
    private static final String LOGIN = System.getProperty("login", DEFAULT_LOGIN);
    private static final String PASSWORD = System.getProperty("password", DEFAULT_PASSWORD);
    private static final String USERNAME = System.getProperty("user", DEFAULT_USERNAME);

    protected User user;

    @BeforeClass
    public void beforeClass(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        context.setAttribute("driver", driver);
        user = new User(LOGIN, PASSWORD, USERNAME);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
