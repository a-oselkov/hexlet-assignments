package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        String[] arrayLetters = letters.split("");
        String[] arrayWord = word.split("");

        List<String> listLetters = new ArrayList<>();
        Collections.addAll(listLetters, arrayLetters);

        List<String> listWord = Arrays.asList(arrayWord);

        int count = 0;
        for (int i = 0; i < listWord.size(); i++)  {
            String wordLetter = listWord.get(i);
            for (int j = 0; j < listLetters.size(); j++) {
                String letter = listLetters.get(j);
                if (wordLetter.equalsIgnoreCase(letter)) {
                    listLetters.remove(letter);
                    count++;
                    break;
                }
            }
            if (count == arrayWord.length) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(App.scrabble("pritevi", "PRIivet"));
    }
}
//END
