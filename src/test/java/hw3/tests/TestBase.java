package hw3.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestBase {

    private static final String DEFAULT_LOGIN = "Roman";
    private static final String DEFAULT_PASSWORD = "Jdi1234";
    private static final String DEFAULT_USERNAME = "ROMAN IOVLEV";
    protected static final String LOGIN = System.getProperty("login", DEFAULT_LOGIN);
    protected static final String PASSWORD = System.getProperty("password", DEFAULT_PASSWORD);
    protected static final String USERNAME = System.getProperty("user", DEFAULT_USERNAME);

    protected static final String EXPECTED_HOME_PAGE_TITLE = "Home Page";

    protected static final SoftAssert softAssert = new SoftAssert();
    protected static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
