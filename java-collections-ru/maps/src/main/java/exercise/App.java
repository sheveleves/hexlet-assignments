package exercise;

import java.util.HashMap;

import java.util.Map;

// BEGIN
public class App {
    public static Map getWordCount(String sentence) {
        Map<String, Integer> wordsMap = new HashMap<>();
        if (sentence.equals("")) {
            return wordsMap;
        }
        String[] wordsSentence = sentence.split(" ");
        for (String s: wordsSentence) {
            if (wordsMap.containsKey(s)) {
                int value = wordsMap.get(s) + 1;
                wordsMap.put(s, value);
            } else {
                wordsMap.put(s, 1);
            }
        }
        return wordsMap;
    }

    public static String toString(Map<String, Integer> wordsMap) {
        if (wordsMap.isEmpty()) {
            return "{}";
        }
        String result = "{\n";
        for (Map.Entry<String, Integer> numberOfWords: wordsMap.entrySet()) {
            result = result.concat("  " + numberOfWords.getKey() + ": " + numberOfWords.getValue() + '\n');
        }
        result = result.concat("}");
        return result;
    }
}
//END
