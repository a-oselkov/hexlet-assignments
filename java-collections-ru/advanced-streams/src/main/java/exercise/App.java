package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String file) {
        String[] lines = file.split("\n");
        String variables = Stream.of(lines)
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replaceAll("\"", ""))
                .map(line -> line.replaceAll("environment=", ""))
                .map(line -> line.split(","))
                .flatMap(line -> Stream.of(line))
                .filter(line -> line.startsWith("X_FORWARDED_"))
                .map(line -> line.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
        return variables;
    }

    public static void main(String[] args) {
        String file = "autorestart=false\n" +
                "environment=\"X_FORWARDED_MAIL=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en\"";
        String result = App.getForwardedVariables(file);
        System.out.println(result);
    }
}
//END
