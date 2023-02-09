package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
	public static List<String> takeOldestMans(List<Map<String, String>> list) {
        return list.stream()
                .filter(human -> human.get("gender").equals("male"))
                .sorted((human1, human2) -> human1.get("birthday").compareTo(human2.get("birthday")))
                .map(human -> human.get("name"))
                .collect(Collectors.toList());
    }
}
// END
