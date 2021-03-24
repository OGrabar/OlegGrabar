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

public class TestBase {

    private static final String DEFAULT_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String URL = System.getProperty("url", DEFAULT_URL);

    private static final String DEFAULT_LOGIN = "Roman";
    private static final String DEFAULT_PASSWORD = "Jdi1234";
    private static final String DEFAULT_USERNAME = "ROMAN IOVLEV";
    private static final String LOGIN = System.getProperty("login", DEFAULT_LOGIN);
    private static final String PASSWORD = System.getProperty("password", DEFAULT_PASSWORD);
    private static final String USERNAME = System.getProperty("user", DEFAULT_USERNAME);

    private static final String EXPECTED_HOME_PAGE_TITLE = "Home Page";

    private static final String LOGIN_DROPDOWN_CLASS_SELECTOR = "uui-profile-menu";
    private static final String LOGIN_INPUT_ID_SELECTOR = "name";
    private static final String PASSWORD_INPUT_ID_SELECTOR = "password";
    private static final String LOGIN_BUTTON_ID_SELECTOR = "login-button";
    private static final String USERNAME_ELEMENT_ID_SELECTOR = "user-name";
    protected static final String TOP_NAVIGATION_BAR_CSS_SELECTOR = ".uui-navigation.nav.navbar-nav.m-l8";
    protected static final String HEADER_ITEM_CSS_SELECTOR = "li a";

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

    protected static void checkBrowserTitle() {
        softAssert.assertEquals(driver.getTitle(), EXPECTED_HOME_PAGE_TITLE);
    }

    protected static void performLogin() {
        WebElement loginDropdown = driver.findElement(By.className(LOGIN_DROPDOWN_CLASS_SELECTOR));
        loginDropdown.click();

        WebElement loginField = driver.findElement(By.id(LOGIN_INPUT_ID_SELECTOR));
        WebElement passwordField = driver.findElement(By.id(PASSWORD_INPUT_ID_SELECTOR));
        WebElement loginButton = driver.findElement(By.id(LOGIN_BUTTON_ID_SELECTOR));
        loginField.sendKeys(LOGIN);
        passwordField.sendKeys(PASSWORD);
        loginButton.click();

        WebElement usernameElement = driver.findElement(By.id(USERNAME_ELEMENT_ID_SELECTOR));
        softAssert.assertTrue(usernameElement.isDisplayed());
        softAssert.assertEquals(usernameElement.getText(), USERNAME);
    }

    protected static List<String> getNotEmptyTextFromWebElements(List<WebElement> webElements) {
        return webElements.stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }
}
