package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {

    public static Long getCountOfFreeEmails(List<String> emails) {
        Long amount = emails.stream()
                .filter(domain -> domain.substring(domain.indexOf("@")).equals("@gmail.com")
                        || domain.substring(domain.indexOf("@")).equals("@yandex.ru")
                        || domain.substring(domain.indexOf("@")).equals("@hotmail.com"))

                .count();
        return amount;
    }
}
// END
