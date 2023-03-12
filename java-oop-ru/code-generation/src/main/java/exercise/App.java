package exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        String json = car.serialize();
        Files.writeString(path, json, StandardCharsets.UTF_8);
    }

    public static Car extract(Path path) throws IOException {
        String json = Files.readString(path);
        Car car = Car.unserialize(json);
        return car;
    }
}
// END
