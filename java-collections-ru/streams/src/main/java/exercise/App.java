package exercise;

import java.util.List;

// BEGIN
public class App {

    public static Long getCountOfFreeEmails(List<String> emails) {
        Long amount = emails.stream()
                .filter(domain -> domain.contains("gmail.com") || domain.endsWith("yandex.ru")
                        || domain.endsWith("hotmail.com"))
                .count();
        return amount;
    }
}
// END
