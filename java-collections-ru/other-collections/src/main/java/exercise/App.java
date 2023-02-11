package exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();
        Map<String, Object> allKeyMap = Stream.of(data1, data2)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, k2) -> k1));
        for (Map.Entry<String, Object> element : allKeyMap.entrySet()) {
            String key = element.getKey();
            Object value = element.getValue();
            if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.put(key, "deleted");
            }
            if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.put(key, "added");
            }
            if (data1.containsKey(key) && data2.containsKey(key) && data1.get(key).equals(data2.get(key))) {
                result.put(key, "unchanged");
            }
            if (data1.containsKey(key) && data2.containsKey(key) && !value.equals(data2.get(key))) {
                result.put(key, "changed");
            }
        }
        Map<String, String> sortMap = new TreeMap<>(result);
        return sortMap;
    }

    public static void main(String[] args) {
        Map<String, Object> firstMap = Map.of("one", "eon", "two", "ozon", "four", true);
        Map<String, Object> secondMap = Map.of("two", "own", "zero", 4, "four", true);
        Map<String, String> result = genDiff(firstMap, secondMap);
        System.out.println(result);
    }
}
//END
