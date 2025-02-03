/*
Difficulty: Medium
Problem: Smallest difference
Pattern: Sorting with merge pattern, greedy approach
 */

import java.util.Arrays;

public class SmallestDifference {
    // O(n log n) + O(m log m) time | O(1) space
    static int[] smallestDifference (int[] firstArr, int[] secondArr) {
        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        int minAbsoluteDifference = Integer.MAX_VALUE;
        int[] pair = new int[2];
        int firstIdx = 0, secondIdx = 0;
        while (firstIdx < firstArr.length && secondIdx < secondArr.length) {
            int currentAbsoluteDifference = absDifference(firstArr[firstIdx], secondArr[secondIdx]);
            if (currentAbsoluteDifference < minAbsoluteDifference) {
                minAbsoluteDifference = currentAbsoluteDifference;
                pair[0] = firstArr[firstIdx];
                pair[1] = secondArr[secondIdx];
            }
            if (firstArr[firstIdx] < secondArr[secondIdx]) firstIdx++;
            else secondIdx++;
        }
        return pair;
    }

    static int absDifference (int a, int b) {
        if (a < b) return b - a;
        return a - b;
    }
}
