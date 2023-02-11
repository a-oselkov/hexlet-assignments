package exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Map<String, String> result = new LinkedHashMap<>();
        Map<String, Object> newMap = Stream.of(firstMap, secondMap)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, k2) -> k1));
        for (Map.Entry<String, Object> element : newMap.entrySet()) {
            var key = element.getKey();
            var value = element.getValue();
            if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                result.put(key, "deleted");
            }
            if (!firstMap.containsKey(key) && secondMap.containsKey(key)) {
                result.put(key, "added");
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key) && firstMap.get(key).equals(secondMap.get(key))) {
                result.put(key, "unchanged");
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key) && !value.equals(secondMap.get(key))) {
                result.put(key, "changed");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Object> firstMap = Map.of("one", "eon", "two", "ozon", "four", true);
        Map<String, Object> secondMap = Map.of("two", "own", "zero", 4, "four", true);
        Map<String, String> result = genDiff(firstMap, secondMap);
        System.out.println(result);
    }
}
//END
