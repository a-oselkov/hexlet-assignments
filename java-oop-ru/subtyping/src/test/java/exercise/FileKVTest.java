package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void fileKVTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));

        storage.set("key2", "value2");

        assertEquals(storage.get("key", "default"), "value");
        assertEquals(storage.get("key2", "default"), "value2");

        storage.unset("key");

        assertEquals(storage.get("key", "default"), "default");
    }
    // END
}
