package hw6.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.google.common.base.Splitter;
import hw6.entities.MetalsAndColorsFormEntity;
import hw6.forms.MetalsAndColorsForm;

import java.util.Map;


public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results")
    private Section result;

    public void submit(MetalsAndColorsFormEntity metalsAndColorsFormEntity) {
        metalsAndColorsForm.submit(metalsAndColorsFormEntity);
    }

    public Map<String, String> getResult() {
        return Splitter.on("\n").withKeyValueSeparator(": ").split(result.getText());
    }
}