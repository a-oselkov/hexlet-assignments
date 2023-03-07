package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        return apartments.stream()
                .sorted((x, y) -> (int) (x.getArea() - y.getArea()))
                .limit(n)
                .map(e -> e.toString())
                .toList();
    }
}
// END
