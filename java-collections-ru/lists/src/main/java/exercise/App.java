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

        int count = 0;
        for (String wordLetter : arrayWord)  {
            for (String letter : listLetters) {
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
