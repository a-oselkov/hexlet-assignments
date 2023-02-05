package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map getWordCount(String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        if (sentence.length() == 0) {
            return wordCount;
        }
        for (String word : words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 0);
            }
            wordCount.put(word, wordCount.get(word) + 1);
        }
        return wordCount;
    }
    public static String toString(Map map) {
        String rezult;
        if (map.isEmpty()) {
            rezult = "{}";
            return rezult;
        }
        rezult = "{\n";
        for (Object word : map.keySet()) {
            rezult += "  " + word + ":" + " " + map.get(word) + "\n";
        }
        rezult += "}";
        return rezult;
    }
    public static void main(String[] args) {
        String sentence = "";
        Map wordsCount = App.getWordCount(sentence);
        String result = App.toString(wordsCount);
        System.out.println(result);
    }
}
//END
