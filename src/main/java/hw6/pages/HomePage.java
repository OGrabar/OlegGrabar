package hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import hw6.entities.User;
import hw6.forms.LoginForm;

public class HomePage extends WebPage {

    @XPath("//header/descendant-or-self::*[contains(text(), 'Metals & Colors')]")
    private Link linkToMetalsAndColorsPage;

    @Css("#login-form")
    private LoginForm loginForm;

    @FindBy(id = "user-icon")
    private Icon loginIcon;

    @FindBy(id = "user-name")
    private Label userName;

    @FindBy(className = "logout")
    private Button logoutButton;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void logout() {
        loginIcon.click();
        logoutButton.click();
    }

    public String getUsername() {
        return userName.getText();
    }

    public void navToMetalsAndColorsPage() {
        linkToMetalsAndColorsPage.click();
    }
}
