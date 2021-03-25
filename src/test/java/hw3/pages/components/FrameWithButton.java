package hw3.pages.components;

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

    public FrameWithButton switchToFrameWithButton() {
        driver.switchTo().frame(frame);
        return this;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getButton() {
        return button;
    }

}
