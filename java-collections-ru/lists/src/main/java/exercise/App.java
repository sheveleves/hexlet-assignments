package exercise;

import java.util.ArrayList;

import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {

        if (letters.length() < word.length()) {
            return false;
        }

        List<Character> listLetters = new ArrayList<>();

        int i = 0;
        while (i < letters.length()) {
            listLetters.add(letters.toLowerCase().charAt(i));
            i++;
        }

        i = 0;
        word = word.toLowerCase();
        while (i < word.length()) {
            var letter = word.charAt(i);
            if (listLetters.contains(letter)) {
                listLetters.remove((Character) letter);
            } else {
                return false;
            }
            i++;
        }
        return true;
    }
}
//END
