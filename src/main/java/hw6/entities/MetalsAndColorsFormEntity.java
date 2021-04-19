package hw6.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hw6.utils.Constants.*;

@Data
@AllArgsConstructor
public class MetalsAndColorsFormEntity {
    private List<Integer> summary;
    private List<String> elements;
    private List<String> vegetables;
    private String color;
    private String metals;

    public Map<String, String> getResult() {
        Map<String, String> result = new HashMap<>();
        Integer summaryResult = summary.stream().reduce(0, Integer::sum);
        String elementsResult = String.join(", ", elements);
        String vegetablesResult = String.join(", ", vegetables);
        result.put(SUMMARY, summaryResult.toString());
        result.put(ELEMENTS, elementsResult);
        result.put(COLOR, color);
        result.put(METAL, metals);
        result.put(VEGETABLES, vegetablesResult);
        return result;
    }
}
