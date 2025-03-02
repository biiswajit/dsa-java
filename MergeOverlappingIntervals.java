/*
Difficulty: Medium
Problem: Merge overlapping intervals
Pattern: Two pointers
 */

import java.util.ArrayList;

public class MergeOverlappingIntervals {
    // O(n) time | O(m) space, where n = length of input array, m = number of non-overlapping intervals
    static ArrayList<int[]> mergeOverlappingIntervals(int[][] intervals) {
        // basic initializations
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]); // add first interval from input intervals into new output intervals
        int currentInterval = 0, nextInterval = 1; // currentIntervals is for output intervals, nextInterval is for input intervals

        // loop until there is no more intervals left in input array
        while (nextInterval < intervals.length) {
            // intervals are not overlapping
            if (mergedIntervals.get(currentInterval)[1] < intervals[nextInterval][0]) {
                mergedIntervals.add(intervals[nextInterval]); // add nextInterval from input array into output intervals
                // update the pointers
                nextInterval += 1;
                currentInterval += 1;
                continue;
            }
            // intervals are overlapping then update the current interval from output intervals
            mergedIntervals.get(currentInterval)[1] = intervals[nextInterval][1];
            nextInterval += 1; // move to next interval from input intervals
        }

        return mergedIntervals;
    }
}
