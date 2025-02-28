/*
Difficulty: Medium
Problem: Longest peak
Pattern: Linear search and peak finding
 */

public class LongestPeak {
    // O(n) time | O(1) space
    static int longestPeak(int[] arr) {
        int lengthOfLongestPeak = Integer.MIN_VALUE;
        // first and last elements can't be the tip of a peak
        int idx = 1;
        while (idx < arr.length-1) {
            // is the current element tip of a peak
            boolean isTipOfPeak = arr[idx] > arr[idx - 1] && arr[idx] > arr[idx + 1];
            // not tip, then check for next element and move on
            if (!isTipOfPeak) {
                idx += 1;
                continue;
            }

            // expand from the tip of peak
            int leftIdx = idx - 2;
            while (leftIdx >= 0 && arr[leftIdx] < arr[leftIdx + 1]) leftIdx -= 1;
            int rightIdx = idx + 2;
            while (rightIdx < arr.length && arr[rightIdx] < arr[rightIdx - 1]) rightIdx += 1;

            // find how much expanded
            int lengthOfCurrentPeak = rightIdx - leftIdx -1;
            lengthOfLongestPeak = Math.max(lengthOfLongestPeak, lengthOfCurrentPeak);

            // look for next peak
            idx = rightIdx;
        }
        return lengthOfLongestPeak;
    }

    public static void main(String[] arr) {
        System.out.println(longestPeak(new int[]{1,2,3,3,4,0,10,6,5,-1,-3,2,3}));
    }
}