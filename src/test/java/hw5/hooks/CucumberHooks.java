package hw5.hooks;

import hw5.driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverSingleton.getDriverInstance();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

}