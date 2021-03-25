package hw3.Utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public final class Utils {

    private Utils() {

    }

    public static List<String> getNotEmptyTextFromWebElements(List<WebElement> webElements) {
        return webElements.stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }
}
