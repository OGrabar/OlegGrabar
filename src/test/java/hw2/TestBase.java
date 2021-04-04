package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TestBase {

    private static final String DEFAULT_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String URL = System.getProperty("url", DEFAULT_URL);

    private static final String EXPECTED_HOME_PAGE_TITLE = "Home Page";

    protected static final SoftAssert softAssert = new SoftAssert();
    protected static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get(URL);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    protected void checkBrowserTitle() {
        softAssert.assertEquals(driver.getTitle(), EXPECTED_HOME_PAGE_TITLE);
    }

    protected void performLogin(LoginUser loginUser) {
        WebElement loginDropdown = driver.findElement(By.className("uui-profile-menu"));
        loginDropdown.click();

        WebElement loginField = driver.findElement(By.id("name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginField.sendKeys(loginUser.getLogin());
        passwordField.sendKeys(loginUser.getPassword());
        loginButton.click();

        WebElement usernameElement = driver.findElement(By.id("user-name"));
        softAssert.assertTrue(usernameElement.isDisplayed());
        softAssert.assertEquals(usernameElement.getText(), loginUser.getUsername());
    }

    protected List<String> getNotEmptyTextFromWebElements(List<WebElement> webElements) {
        return webElements.stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }
}
