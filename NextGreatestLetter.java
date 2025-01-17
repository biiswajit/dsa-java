/*
Problem: 744. Find Smallest Letter Greater Than Target
Pattern: Binary Search
Difficulty: Easy
 */

public class NextGreatestLetter {
    // typical binary search
    // Time complexity: O(logN)
    // Space complexity: O(1)
    static char nextGreatestLetter(char[] letters, char target) {
        int startIdx = 0, endIdx = letters.length - 1;
        while (startIdx <= endIdx) {
            // don't stop the loop instead look at right side
            int midIdx = (endIdx - startIdx) / 2 + startIdx;
            if (target == letters[midIdx]) startIdx = midIdx + 1;
            else if (target < letters[midIdx]) endIdx = midIdx - 1;
            else startIdx = midIdx + 1;
        }
        // checking whether startIdx is an invalid index or not
        if (startIdx <= 0 || startIdx >= letters.length) startIdx = 0;
        return letters[startIdx];
    }
}
