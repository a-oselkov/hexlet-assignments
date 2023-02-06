package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String,String>> bookShelf, Map<String, String> targetBooks) {
        List<Map<String, String>> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < bookShelf.size(); i++) {
            Map<String, String> bookFromShelf = bookShelf.get(i);
            for (Map.Entry<String, String> book1 : bookFromShelf.entrySet()) {
            for (Map.Entry<String, String> book2 : targetBooks.entrySet()) {

                    if (book1.getValue().equals(book2.getValue())) {
                        count++;
                    }
                }
            }
            if (count == targetBooks.size()) {
                result.add(bookFromShelf);
                count = 0;
            }
        }
        return result;
    }
}
//END
