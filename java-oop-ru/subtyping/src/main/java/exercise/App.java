package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        for (Map.Entry<String, String> pair : storage.toMap().entrySet()) {
            storage.set(pair.getValue(), pair.getKey());
            storage.unset(pair.getKey());
        }
    }
}
// END
