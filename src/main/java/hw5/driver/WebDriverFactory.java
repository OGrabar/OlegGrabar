package hw5.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String OPERA = "opera";

    private WebDriverFactory() {}

    public static WebDriver getWebDriver(String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case FIREFOX:
                driver = getFirefoxDriver();
                break;
            case OPERA:
                driver = getOperaDriver();
                break;
            default:
                driver = getChromeDriver();
                break;

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver getOperaDriver() {
       WebDriverManager.operadriver().setup();
       return new OperaDriver();
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
