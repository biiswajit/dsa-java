/*
Difficulty: Easy
Problem: 392. Is Subsequence
Pattern: Linear search
 */

public class ValidateSubsequence {
    // time complexity O(N)
    // space complexity O(1)
    boolean validateSubsequence(int[] array, int[] seq) {
        int aIdx = 0, sIdx = 0;
        while (aIdx < array.length && sIdx < seq.length) {
            if (array[aIdx] == seq[sIdx]) sIdx += 1;
            aIdx += 1;
        }
        return sIdx >= seq.length;
    }
}
