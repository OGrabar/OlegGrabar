package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstExerciseTest extends TestBase {

    private static final int EXPECTED_BENEFITS_COUNT = 4;
    private static final List<String> EXPECTED_BENEFIT_TEXTS = new ArrayList<String>() {{
        add("To include good practices\nand ideas from successful\nEPAM project");
        add("To be flexible and\ncustomizable");
        add("To be multiplatform");
        add("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    }};
    private static final List<String> EXPECTED_HEADER_ITEMS_TEXT = new ArrayList<String>() {{
        add("HOME");
        add("CONTACT FORM");
        add("SERVICE");
        add("METALS & COLORS");
    }};
    private static final List<String> EXPECTED_SIDE_NAV_BAR_ITEMS_TEXT = new ArrayList<String>() {{
        add("Home");
        add("Contact form");
        add("Service");
        add("Metals & Colors");
        add("Elements packs");
    }};

    @Test
    public void firstExerciseTest() {
        //2.Assert Browser title
        checkBrowserTitle();
        //3-4. Perform login. Assert Username is logined
        performLogin(LoginUser.ROMAN);

        //5.Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> topNavigationBarItems = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8"))
                .findElements(By.cssSelector("li a"));
        List<String> headerItemsText = getNotEmptyTextFromWebElements(topNavigationBarItems);
        softAssert.assertEquals(headerItemsText, EXPECTED_HEADER_ITEMS_TEXT);

        //6.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsImages = driver.findElements(By.className("benefit-icon")).stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
        softAssert.assertEquals(benefitsImages.size(), EXPECTED_BENEFITS_COUNT);

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper tex
        List<WebElement> benefitsTextWebElements = driver.findElements(By.className("benefit-txt"));
        List<String> benefitTexts = getNotEmptyTextFromWebElements(benefitsTextWebElements);
        softAssert.assertEquals(benefitTexts, EXPECTED_BENEFIT_TEXTS);

        //8.Assert that there is the iframe with “Frame Button” exist
        WebElement frameWithButton = driver.findElement(By.id("frame"));
        softAssert.assertNotNull(frameWithButton);

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(frameWithButton);
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssert.assertNotNull(frameButton);

        //10.Switch to original window back
        driver.switchTo().defaultContent();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sideNavigationBarItems = driver.findElement(By.name("navigation-sidebar"))
                .findElements(By.cssSelector("li span"));
        List<String> sideNavigationBarItemsText = getNotEmptyTextFromWebElements(sideNavigationBarItems);
        softAssert.assertEquals(sideNavigationBarItemsText, EXPECTED_SIDE_NAV_BAR_ITEMS_TEXT);

        softAssert.assertAll();
    }
}
