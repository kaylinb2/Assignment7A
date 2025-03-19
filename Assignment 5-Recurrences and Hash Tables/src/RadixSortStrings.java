import java.util.*;

public class RadixSortStrings {

    /**
     * Performs radix sort on an array of strings to sort them lexicographically.
     * The sorting is done character by character from right to left, ensuring
     * that words are sorted based on their least significant character first.
     *
     * @param arr The array of strings to be sorted.
     */
    public static void radixSort(String[] arr) {
        if (arr.length == 0) return; // If the input array is empty, there is nothing to sort.

        // Step 1: Find the maximum string length in the array
        // This determines the number of iterations required for sorting.
        int maxLength = 0;
        for (String s : arr) {
            maxLength = Math.max(maxLength, s.length()); // Track the longest string length.
        }

        // Step 2: Perform sorting from the rightmost character to the leftmost character
        for (int i = maxLength - 1; i >= 0; i--) {
            // Step 2.1: Use a TreeMap to store lists of words based on the current character.
            // The TreeMap ensures that keys (characters) are sorted in lexicographic order.
            Map<Character, List<String>> buckets = new TreeMap<>();

            // Step 2.2: Initialize buckets for all possible characters from space (' ') to 'z'
            for (char c = ' '; c <= 'z'; c++) {
                buckets.put(c, new ArrayList<>()); // Create an empty list for each character.
            }

            // Step 2.3: Distribute words into corresponding buckets based on the current character index
            for (String word : arr) {
                // If the current index is within the string length, use that character.
                // Otherwise, use space (' ') as padding to ensure uniformity in sorting.
                char key = i < word.length() ? word.charAt(i) : ' ';
                buckets.get(key).add(word); // Add word to the corresponding bucket.
            }

            // Step 2.4: Collect words from buckets back into the original array in sorted order.
            int index = 0;
            for (List<String> bucket : buckets.values()) {
                for (String word : bucket) {
                    arr[index++] = word; // Overwrite original array with sorted order.
                }
            }
        }
    }

    public static void main(String[] args) {
        // Sample input: An array of words to be sorted lexicographically.
        String[] words = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        // Call radix sort to sort the array.
        radixSort(words);

        // Print the sorted array.
        System.out.println(String.join(" ", words));
    }
}
