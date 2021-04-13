package hw5.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameWithButton extends BaseComponent{

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement button;

    public FrameWithButton(WebDriver driver) {
        super(driver);
    }

    public void switchToFrameWithButton() {
        driver.switchTo().frame(frame);
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getButton() {
        return button;
    }
}
