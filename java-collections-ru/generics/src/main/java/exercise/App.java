package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static <T> List<Map<T, T>> findWhere(List<Map<T, T>> bookShelf, Map<T, T> targetBooks) {
        List<Map<T, T>> result = new ArrayList<>();
        for (int i = 0; i < bookShelf.size(); i++) {
            int count = 0;
            Map<T, T> bookFromShelf = bookShelf.get(i);
            for (Map.Entry<T, T> book1 : bookFromShelf.entrySet()) {
                for (Map.Entry<T, T> book2 : targetBooks.entrySet()) {
                    if (book1.getValue().equals(book2.getValue())) {
                        count++;
                    }
                }
            }
            if (count == targetBooks.size()) {
                result.add(bookFromShelf);
            }
        }
        return result;
    }
}
//END
