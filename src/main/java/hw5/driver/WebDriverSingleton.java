package hw5.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static final String DEFAULT_BROWSER = "chrome";
    private static final String BROWSER = System.getProperty("browser", DEFAULT_BROWSER);

    private static  WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            driver = WebDriverFactory.getWebDriver(BROWSER);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
