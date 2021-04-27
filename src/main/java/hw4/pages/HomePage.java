package hw4.pages;

import java.util.List;

import hw4.users.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import hw4.pages.components.FrameWithButton;

import static hw4.utils.Utils.getNotEmptyTextFromWebElements;

public class HomePage extends BasePage {

    private static final String DEFAULT_HOME_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String HOME_PAGE_URL = System.getProperty("url.home", DEFAULT_HOME_PAGE_URL);

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTextItems;

    private final FrameWithButton frameWithButton;

    public HomePage(WebDriver driver) {
        super(driver);
        frameWithButton = new FrameWithButton(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    @Override
    public HomePage performLogin(User user) {
        super.performLogin(user);
        return this;
    }

    public List<WebElement> getBenefitsImages() {
        return benefitIcons;
    }

    public List<String> getBenefitsText() {
        return getNotEmptyTextFromWebElements(benefitTextItems);
    }

    public WebElement getFrameWithButton() {
        return frameWithButton.getFrame();
    }

    public FrameWithButton switchToFrameWithButton() {
        return frameWithButton.switchToFrameWithButton();
    }

    public WebElement getFrameButton() { return frameWithButton.getButton(); }

    public void switchToIndexPage() {
        driver.switchTo().defaultContent();
    }
}
