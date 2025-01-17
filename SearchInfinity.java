/*
Problem: perform binary search in an infinite array
Difficulty: Medium
Pattern: binary search
 */

public class SearchInfinity {
    // difficult part: since it is an infinite array we can not get the length of the array, hence we can not find the middle index
    // idea ? binary search in chunks, and in each iteration double the size of chunk

    // consider the array is infinite array
    static int binarySearch(int[] arr, int target) {
        // get the appropriate finite range to binary search
        int[] range = find(arr, target);
        int start = range[0], end = range[1];
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (target == arr[mid]) return mid;
            else if (target < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    // time complexity: O(log N)
    // space complexity: O(1)
    static int[] find(int[] arr, int target) {
        int start = 0, end = 1;
        // handling array index out of bound exception
        try {
            // assuming the array is infinite
            while (true) {
                if (target <= arr[end]) return new int[]{start, end};
                // in each iteration double the size of range
                int size = (end - start) + 1;
                start = end + 1;
                end = end + (size * 2);
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            return new int[]{-1, -2};
        }
    }
}
