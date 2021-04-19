package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.entities.MetalsAndColorsFormEntity;
import hw6.entities.User;
import hw6.providers.JsonDataProvider;
import org.testng.annotations.*;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class JdiTest {


    @BeforeTest(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "metalsAndColorsEntitiesFormJson", dataProviderClass = JsonDataProvider.class)
    public void testSubmitMetalsAndColors(MetalsAndColorsFormEntity metalsAndColorsFormEntity) {
        JdiSite.open();
        JdiSite.login(User.ROMAN);
        assertEquals(JdiSite.getUsername(), User.ROMAN.getUsername());
        JdiSite.navToMetalsAndColorsPage();
        JdiSite.submitMetalsAndColorsForm(metalsAndColorsFormEntity);
        Map<String, String> expectedResult = metalsAndColorsFormEntity.getResult();
        Map<String, String> actualResult = JdiSite.getMetalsAndColorsPageResult();
        assertEquals(actualResult, expectedResult);
        JdiSite.logout();
    }

}