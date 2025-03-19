import java.util.*;
import java.util.regex.Pattern;

/**
 * This class checks whether a given string follows a specified pattern,
 * considering a given delimiter that separates words in the string.
 */
public class WordPatternChecker {

    /**
     * Checks if the given string follows the pattern.
     * The function ensures that each character in the pattern maps uniquely to a word,
     * and each word maps uniquely to a character.
     *
     * @param pattern   The pattern string containing lowercase letters.
     * @param delimiter The delimiter character used to separate words in the input string.
     * @param s         The input string containing words separated by the delimiter.
     * @return true if the string follows the pattern, otherwise false.
     */
    public static boolean wordPattern(String pattern, char delimiter, String s) {
        // Trim pattern to remove unintended spaces
        pattern = pattern.replaceAll("\\s", "");

        // Step 1: Split the string into words based on the given delimiter
        String[] words = s.split(Pattern.quote(String.valueOf(delimiter)));

        // Step 2: If the number of words does not match the pattern length, return false
        if (words.length != pattern.length()) return false;

        // Step 3: Create mappings for character-to-word and word-to-character relationships
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        // Step 4: Iterate through the pattern and corresponding words
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Step 4.1: Check if the character has already been mapped to a word
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) return false; // If mismatch, return false
            } else {
                charToWord.put(c, word); // Store new mapping
            }

            // Step 4.2: Check if the word has already been mapped to a character
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) return false; // If mismatch, return false
            } else {
                wordToChar.put(word, c); // Store new mapping
            }
        }

        // Step 5: If all mappings are valid, return true
        return true;
    }

    /**
     * Main method to test the wordPattern function with example cases.
     */
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", '?', "dog?cat?cat?dog")); // true
        System.out.println(wordPattern("abba", '|', "apple|banana|grape|apple")); // false
        System.out.println(wordPattern("aaaa", ',', "dog,cat,cat,dog")); // false
        System.out.println(wordPattern("aaaa", ' ', "ice cream taco day")); // false
        System.out.println(wordPattern("adx p", ' ', "ice cream taco day")); // true
    }
}