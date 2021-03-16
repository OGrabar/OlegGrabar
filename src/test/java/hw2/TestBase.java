package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    private static final String TITLE = "Home Page";

    private static final String LOGIN = "Roman";
    private static final String PASSWORD = "Jdi1234";

    private static final String EXPECTED_USERNAME = "ROMAN IOVLEV";

    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
