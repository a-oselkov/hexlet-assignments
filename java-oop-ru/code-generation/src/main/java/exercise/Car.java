package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

    public static Car unserialize(String jsonRepresentation) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(jsonRepresentation, Car.class);
        return car;
    }
    // END
}
