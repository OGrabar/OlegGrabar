package hw6.providers;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.util.*;

import hw6.entities.MetalsAndColorsFormEntity;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


public class JsonDataProvider {
    private static final String DEFAULT_DATA_PATH = "src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json";
    private static final String DATA_PATH = System.getProperty("data.path", DEFAULT_DATA_PATH);

    @SneakyThrows
    @DataProvider
    public static Iterator<Object[]> metalsAndColorsEntitiesFormJson() {
        String jsonString = new String(Files.readAllBytes(Paths.get(DATA_PATH)), StandardCharsets.UTF_8);
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        Set<String> keySet = jsonParser.parse(jsonString).getAsJsonObject().keySet();
        List<MetalsAndColorsFormEntity> entities = new ArrayList<>();
        for (String key : keySet) {
            String s = jsonParser.parse(jsonString).getAsJsonObject().get(key).toString();
            entities.add(gson.fromJson(s, MetalsAndColorsFormEntity.class));
        }
        return entities.stream()
                .map(entity -> new Object[]{entity})
                .collect(Collectors.toList())
                .iterator();
    }
}