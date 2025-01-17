/*
Difficulty: Medium
Pattern: Binary Search
Question: 34. Find First and Last Position of Element in Sorted Array
 */
public class SearchRange {
    // typical binary search
    // time complexity: O(log N + M)
    // space complexity: O(1)
    static int[] searchRangeI(int[] nums, int target) {
        int startIdx = 0, endIdx = nums.length - 1;
        while (startIdx <= endIdx) {
            int midIdx = (endIdx - startIdx) / 2 + startIdx;
            if (target == nums[midIdx]) {
                // run two linear searches to find the start and index
                startIdx = midIdx;
                while (validIdx(startIdx, nums.length) && target == nums[startIdx]) startIdx -= 1;
                endIdx = midIdx;
                while (validIdx(endIdx, nums.length) && target == nums[endIdx]) endIdx += 1;
                return new int[]{startIdx + 1, endIdx - 1};
            }
            else if (target < nums[midIdx]) endIdx = midIdx - 1;
            else startIdx = midIdx + 1;
        }
        return new int[]{-1, -1};
    }

    static boolean validIdx(int idx, int n) {
        return idx >= 0 && idx < n;
    }

    // helper function uses binary search to find the index of target
    static int search(int[] nums, int target, boolean findStart) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (target == nums[mid]) {
                ans = mid;
                // keep going left side to find start index, keep going right side to find end index
                if (findStart) end = mid - 1;
                else start = mid + 1;
            }
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return ans;
    }

    // time complexity: O(log N)
    // space complexity: O(1)
    static int[] searchRangeII(int[] nums, int target) {
        int startIdx = -1, endIdx = -1;
        // perform binary search to find the start and end index
        startIdx = search(nums, target, true);
        endIdx = search(nums, target, false);
        return new int[] {startIdx, endIdx};
    }
}
