package hw3.tests;

import hw3.users.User;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public abstract class TestBase {

    protected static final String EXPECTED_HOME_PAGE_TITLE = "Home Page";
    protected static final SoftAssert softAssert = new SoftAssert();
    protected static WebDriver driver;

    private static final String DEFAULT_LOGIN = "Roman";
    private static final String DEFAULT_PASSWORD = "Jdi1234";
    private static final String DEFAULT_USERNAME = "ROMAN IOVLEV";
    private static final String LOGIN = System.getProperty("login", DEFAULT_LOGIN);
    private static final String PASSWORD = System.getProperty("password", DEFAULT_PASSWORD);
    private static final String USERNAME = System.getProperty("user", DEFAULT_USERNAME);

    protected User user;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        user = new User(LOGIN, PASSWORD, USERNAME);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
