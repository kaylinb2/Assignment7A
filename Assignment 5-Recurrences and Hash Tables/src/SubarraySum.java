import java.util.*;

/**
 * This class finds contiguous subarrays within an array that sum up to a given target K.
 * If multiple subarrays exist, it returns all possible valid subarrays.
 * If no subarray exists, it returns [-1, -1].
 */
public class SubarraySum {

    /**
     * Finds all subarrays in the given array A whose sum equals K.
     * Uses a sliding window (two-pointer) approach to efficiently find subarrays in O(n) time.
     *
     * @param A The input array of non-negative integers.
     * @param K The target sum.
     * @return A list of integer pairs representing the start and end indices of valid subarrays.
     */
    public static List<int[]> sumTarget(int[] A, int K) {
        List<int[]> result = new ArrayList<>(); // Stores the start and end indices of valid subarrays
        int left = 0, sum = 0; // Left pointer and cumulative sum

        // Iterate through the array using the right pointer
        for (int right = 0; right < A.length; right++) {
            sum += A[right]; // Expand window by adding the current element

            // Shrink the window if sum exceeds K
            while (sum > K && left <= right) {
                sum -= A[left]; // Remove elements from the left
                left++;
            }

            // If a valid subarray is found, store its indices
            if (sum == K) {
                result.add(new int[]{left, right});
            }
        }

        // If no valid subarray was found, return [-1, -1]
        if (result.isEmpty()) {
            result.add(new int[]{-1, -1});
        }
        return result;
    }

    /**
     * Main method to test the sumTarget function.
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 7, 5}; // Example input array
        int K = 7; // Target sum

        List<int[]> results = sumTarget(A, K); // Find subarrays with sum K

        // Print each result in the form [start, end]
        for (int[] res : results) {
            System.out.println(Arrays.toString(res));
        }
    }
}
