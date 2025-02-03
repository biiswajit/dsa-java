/*
Difficulty: Medium
Problem: Three number sum
Pattern: Linear search with sorting and two pointer
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeNumberSum {
    // O(n^2) time | O(p) space, where p is the number of triplets
    static ArrayList<int[]> threeNumberSum (int[] nums, int target) {
        // sort the input array
        Arrays.sort(nums);
        // to store all triplets
        ArrayList<int[]> triplets = new ArrayList<>();
        // fix the first number, starting from first index
        for (int firstIdx=0; firstIdx<nums.length-2; firstIdx++) {
            // initialize the second and third indices
            int secondIdx = firstIdx + 1, thirdIdx = nums.length-1;
            // just simple two pointer loop
            while (secondIdx < thirdIdx) {
                int currentSum = nums[firstIdx] + nums[secondIdx] + nums[thirdIdx];
                if (currentSum == target) triplets.add(new int[]{nums[firstIdx], nums[secondIdx], nums[thirdIdx]});
                if (currentSum > target) thirdIdx--;
                else secondIdx++;
            }
        }
        return triplets;
    }
}
