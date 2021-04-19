package hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw6.entities.MetalsAndColorsFormEntity;
import hw6.entities.User;
import hw6.pages.HomePage;
import hw6.pages.MetalsAndColorsPage;

import java.util.Map;


@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    public static HomePage homePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homePage.open();
    }

    public static void login(User user) {
        homePage.login(user);
    }

    public static void logout() {
        homePage.logout();
    }

    public static void navToMetalsAndColorsPage() {
        homePage.navToMetalsAndColorsPage();
    }

    public static void submitMetalsAndColorsForm(MetalsAndColorsFormEntity metalsAndColorsFormEntity) {
        metalsAndColorsPage.submit(metalsAndColorsFormEntity);
    }

    public static Map<String, String> getMetalsAndColorsPageResult() {
        return metalsAndColorsPage.getResult();
    }

    public static String getUsername() {
        return homePage.getUsername();
    }
}