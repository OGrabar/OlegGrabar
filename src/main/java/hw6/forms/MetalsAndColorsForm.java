package hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.List;

import hw6.entities.MetalsAndColorsFormEntity;

import static hw6.utils.Constants.VEGETABLES;


public class MetalsAndColorsForm extends Form<MetalsAndColorsFormEntity> {

    @Css("[name='custom_radio_odd']")
    private RadioButtons oddSummaryRadioButtonsRow;

    @Css("[name='custom_radio_even']")
    private RadioButtons evenSummaryRadioButtonsRow;

    @Css("#elements-checklist .checkbox input")
    private Checklist elementsCheckList;

    @Css("#salad-dropdown > button")
    private Button vegetablesButton;

    @Css("#salad-dropdown ul li a input")
    private Checklist vegetablesCheckList;

    @Css("#metals")
    @JDropdown(expand=".caret")
    private Dropdown metalsDropdown;

    @Css("#colors")
    @JDropdown(expand=".caret")
    private Dropdown colorsDropdown;

    @Css("#submit-button")
    private Button submitButton;

    public void submit(MetalsAndColorsFormEntity metalsAndColorsFormEntity) {
        List<Integer> summary = metalsAndColorsFormEntity.getSummary();
        summary.forEach(number -> {
            if (number % 2 == 0) {
                evenSummaryRadioButtonsRow.select(number / 2);
            } else {
                oddSummaryRadioButtonsRow.select(number / 2 + 1);
            }
        });

        metalsAndColorsFormEntity.getElements().forEach(element -> elementsCheckList.select(element));
        colorsDropdown.select(metalsAndColorsFormEntity.getColor());
        metalsDropdown.select(metalsAndColorsFormEntity.getMetals());
        vegetablesButton.click();
        vegetablesCheckList.select(VEGETABLES);
        metalsAndColorsFormEntity.getVegetables().forEach(vegetable -> vegetablesCheckList.select(vegetable));
        submitButton.click();
    }
}