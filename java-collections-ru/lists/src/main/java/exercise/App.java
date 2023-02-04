package exercise;

import java.util.Arrays;
import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        word = word.toLowerCase();
        char[] arrayLetters = letters.toCharArray();
        char[] arrayWord = word.toCharArray();
        int count = 0;
        for (int i = 0; i < arrayWord.length; i++)  {
            for (int j = 0; j < arrayLetters.length; j++) {
                if (arrayWord[i] == arrayLetters[j]) {
                    arrayLetters[j] = '*';
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
